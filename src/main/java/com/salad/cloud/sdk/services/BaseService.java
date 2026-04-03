package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiError;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.ModelConverter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Base service class that all API service classes extend.
 * Provides common functionality including HTTP request execution, error handling,
 * and configuration management.
 */
public class BaseService {

  private static final Logger logger = Logger.getLogger(BaseService.class.getName());
  protected OkHttpClient httpClient;
  protected SaladCloudSdkConfig config;
  protected Map<Integer, ErrorMapping<?>> errorMappings;
  protected ErrorMapping<?> defaultErrorMapping;

  /**
   * Internal class for mapping HTTP status codes to error models and exception types.
   *
   * @param <T> The error model type
   */
  private static class ErrorMapping<T> {

    private final Class<T> modelClass;
    private final Class<? extends ApiError> exceptionClass;

    public ErrorMapping(Class<T> modelClass, Class<? extends ApiError> exceptionClass) {
      this.modelClass = modelClass;
      this.exceptionClass = exceptionClass;
    }
  }

  /**
   * Constructs a new BaseService instance.
   *
   * @param httpClient The HTTP client to use for making requests
   * @param config The SDK configuration
   */
  public BaseService(OkHttpClient httpClient, SaladCloudSdkConfig config) {
    this.httpClient = httpClient;
    this.config = config;
    this.errorMappings = new HashMap<>();
  }

  /**
   * Sets the base URL for API requests.
   *
   * @param baseUrl The base URL to use
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  /**
   * Sets the environment for API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    this.config.setEnvironment(environment);
  }

  /**
   * Registers an error mapping for a specific HTTP status code.
   * When a response with this status is received, the SDK will deserialize the error
   * response to the specified model class and throw the specified exception type.
   *
   * @param <T> The error model type
   * @param status The HTTP status code to map
   * @param modelClass The class to deserialize the error response into
   * @param exceptionClass The exception class to throw
   */
  protected <T> void addErrorMapping(int status, Class<T> modelClass, Class<? extends ApiError> exceptionClass) {
    this.errorMappings.put(status, new ErrorMapping<>(modelClass, exceptionClass));
  }

  /**
   * Registers a default error mapping for unmapped HTTP status codes.
   * When a response with an unmapped status is received the SDK will deserialize the error
   * response to the specified model class and throw the specified exception type.
   *
   * @param <T> The error model type
   * @param modelClass The class to deserialize the error response into
   * @param exceptionClass The exception class to throw
   */
  protected <T> void addDefaultErrorMapping(Class<T> modelClass, Class<? extends ApiError> exceptionClass) {
    this.defaultErrorMapping = new ErrorMapping<>(modelClass, exceptionClass);
  }

  /**
   * Extracts an error message from a response and optional error model.
   * Attempts to get the message from the error model's getMessage() method,
   * falls back to the response message, or constructs a message from the status code and URL.
   *
   * @param response The HTTP response
   * @param errorModel The deserialized error model (may be null)
   * @return The extracted or constructed error message
   */
  private String extractErrorMessage(Response response, Object errorModel) {
    String message = null;

    if (errorModel != null) {
      try {
        message = (String) errorModel.getClass().getMethod("getMessage").invoke(errorModel);
      } catch (Exception e) {
        // Ignore if getMessage doesn't exist or fails
      }
    }

    if (Objects.isNull(message) || message.trim().isEmpty()) {
      message = response.message();
    }

    if (Objects.isNull(message) || message.trim().isEmpty()) {
      message = String.format("%d error in request to: %s", response.code(), response.request().url());
    }

    return message;
  }

  /**
   * Executes an HTTP request synchronously.
   * Handles error responses by checking error mappings and throwing appropriate exceptions.
   *
   * @param request The HTTP request to execute
   * @return The HTTP response if successful
   * @throws ApiError if the request fails or returns an error status code
   */
  protected Response execute(Request request) throws ApiError {
    Response response;
    try {
      response = this.httpClient.newCall(request).execute();
    } catch (IOException e) {
      if (e instanceof SocketTimeoutException) {
        throw new ApiError("Request timed out", 408, null);
      }
      throw new ApiError(e.getMessage(), 0, null);
    }

    if (response.isSuccessful()) {
      return response;
    }

    // Handle error response
    ErrorMapping<?> errorMapping = this.errorMappings.getOrDefault(response.code(), this.defaultErrorMapping);
    if (errorMapping != null) {
      Object errorModel = null;
      try {
        errorModel = ModelConverter.convert(response, errorMapping.modelClass);
      } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to deserialize error response to " + errorMapping.modelClass.getName(), e);
      }

      if (errorModel != null) {
        try {
          Constructor<? extends ApiError> constructor = errorMapping.exceptionClass.getConstructor(
            errorMapping.modelClass,
            String.class,
            int.class,
            Response.class
          );
          String message = extractErrorMessage(response, errorModel);
          throw constructor.newInstance(errorModel, message, response.code(), response);
        } catch (ReflectiveOperationException e) {
          logger.log(
            Level.WARNING,
            "Failed to create exception instance for " + errorMapping.exceptionClass.getName(),
            e
          );
        }
      }
    }

    // If no specific error model is mapped or conversion failed, throw generic ApiError
    throw new ApiError(extractErrorMessage(response, null), response.code(), response);
  }

  /**
   * Executes an HTTP request asynchronously.
   * Returns a CompletableFuture that completes with the response or completes exceptionally
   * if an error occurs. Handles error responses by checking error mappings.
   *
   * @param request The HTTP request to execute
   * @return A CompletableFuture that completes with the HTTP response
   */
  protected CompletableFuture<Response> executeAsync(Request request) {
    CompletableFuture<Response> future = new CompletableFuture<>();
    this.httpClient.newCall(request).enqueue(
        new Callback() {
          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) {
            if (!response.isSuccessful()) {
              // Handle error response
              ErrorMapping<?> errorMapping = errorMappings.get(response.code());
              if (errorMapping != null) {
                try {
                  Object errorModel = ModelConverter.convert(response, errorMapping.modelClass);
                  if (errorModel != null) {
                    // Use reflection to create the exception
                    Constructor<? extends ApiError> constructor = errorMapping.exceptionClass.getConstructor(
                      errorMapping.modelClass,
                      String.class,
                      int.class,
                      Response.class
                    );
                    String message = extractErrorMessage(response, errorModel);
                    future.completeExceptionally(
                      constructor.newInstance(errorModel, message, response.code(), response)
                    );
                    return;
                  }
                } catch (Exception e) {
                  logger.log(
                    Level.WARNING,
                    "Failed to deserialize error response to " + errorMapping.modelClass.getName(),
                    e
                  );
                }
              }

              // If no specific error model is mapped or conversion failed, throw generic ApiError
              ApiError error = new ApiError(extractErrorMessage(response, null), response.code(), response);
              future.completeExceptionally(error);
              return;
            }

            future.complete(response);
          }

          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            if (e instanceof SocketTimeoutException) {
              ApiError error = new ApiError("Request timed out", 408, null);
              future.completeExceptionally(error);
            } else {
              ApiError error = new ApiError(e.getMessage(), 0, null);
              future.completeExceptionally(error);
            }
          }
        }
      );
    return future;
  }
}
