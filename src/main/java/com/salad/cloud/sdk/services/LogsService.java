package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiError;
import com.salad.cloud.sdk.exceptions.ProblemDetailsException;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.LogEntryCollection;
import com.salad.cloud.sdk.models.LogEntryQuery;
import com.salad.cloud.sdk.models.ProblemDetails;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.LogEntryQueryValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * LogsService Service
 */
public class LogsService extends BaseService {

  /**
   * Constructs a new instance of LogsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public LogsService(@NonNull OkHttpClient httpClient, SaladCloudSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Query Log Entries
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param logEntryQuery {@link LogEntryQuery} Request Body
   * @return response of {@code LogEntryCollection}
   */
  public LogEntryCollection queryLogEntries(@NonNull String organizationName, @NonNull LogEntryQuery logEntryQuery)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildQueryLogEntriesRequest(organizationName, logEntryQuery);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<LogEntryCollection>() {});
  }

  /**
   * Query Log Entries
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param logEntryQuery {@link LogEntryQuery} Request Body
   * @return response of {@code CompletableFuture<LogEntryCollection>}
   */
  public CompletableFuture<LogEntryCollection> queryLogEntriesAsync(
    @NonNull String organizationName,
    @NonNull LogEntryQuery logEntryQuery
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(401, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(403, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(404, ProblemDetails.class, ProblemDetailsException.class);
    this.addErrorMapping(429, ProblemDetails.class, ProblemDetailsException.class);
    this.addDefaultErrorMapping(ProblemDetails.class, ProblemDetailsException.class);
    Request request = this.buildQueryLogEntriesRequest(organizationName, logEntryQuery);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<LogEntryCollection>() {});
    });
  }

  private Request buildQueryLogEntriesRequest(@NonNull String organizationName, @NonNull LogEntryQuery logEntryQuery)
    throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(new LogEntryQueryValidator("logEntryQuery").required().validate(logEntryQuery))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/log-entries"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setJsonContent(logEntryQuery)
      .build();
  }
}
