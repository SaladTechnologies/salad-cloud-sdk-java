package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiError;
import com.salad.cloud.sdk.exceptions.ProblemDetailsException;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.ProblemDetails;
import com.salad.cloud.sdk.models.WebhookSecretKey;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * WebhookSecretKeyService Service
 */
public class WebhookSecretKeyService extends BaseService {

  /**
   * Constructs a new instance of WebhookSecretKeyService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public WebhookSecretKeyService(@NonNull OkHttpClient httpClient, SaladCloudSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Gets the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public WebhookSecretKey getWebhookSecretKey(@NonNull String organizationName) throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetWebhookSecretKeyRequest(organizationName);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebhookSecretKey>() {});
  }

  /**
   * Gets the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code CompletableFuture<WebhookSecretKey>}
   */
  public CompletableFuture<WebhookSecretKey> getWebhookSecretKeyAsync(@NonNull String organizationName)
    throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildGetWebhookSecretKeyRequest(organizationName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebhookSecretKey>() {});
    });
  }

  private Request buildGetWebhookSecretKeyRequest(@NonNull String organizationName) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/webhook-secret-key"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .build();
  }

  /**
   * Updates the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public WebhookSecretKey updateWebhookSecretKey(@NonNull String organizationName)
    throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildUpdateWebhookSecretKeyRequest(organizationName);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebhookSecretKey>() {});
  }

  /**
   * Updates the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code CompletableFuture<WebhookSecretKey>}
   */
  public CompletableFuture<WebhookSecretKey> updateWebhookSecretKeyAsync(@NonNull String organizationName)
    throws ApiError, ValidationException {
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildUpdateWebhookSecretKeyRequest(organizationName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebhookSecretKey>() {});
    });
  }

  private Request buildUpdateWebhookSecretKeyRequest(@NonNull String organizationName) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/webhook-secret-key"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .build();
  }
}
