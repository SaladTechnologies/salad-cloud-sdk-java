package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointCollection;
import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobCollection;
import com.salad.cloud.sdk.models.InferenceEndpointJobPrototype;
import com.salad.cloud.sdk.models.ListInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.InferenceEndpointJobPrototypeValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.ListInferenceEndpointJobsParametersValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.ListInferenceEndpointsParametersValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * InferenceEndpointsService Service
 */
public class InferenceEndpointsService extends BaseService {

  public InferenceEndpointsService(@NonNull OkHttpClient httpClient, SaladCloudSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * List Inference Endpoints
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param requestParameters {@link ListInferenceEndpointsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointCollection}
   */
  public InferenceEndpointCollection listInferenceEndpoints(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointCollection>() {});
  }

  /**
   * List Inference Endpoints
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param requestParameters {@link ListInferenceEndpointsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InferenceEndpointCollection>}
   */
  public CompletableFuture<InferenceEndpointCollection> listInferenceEndpointsAsync(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointCollection>() {})
    );
  }

  private Request buildListInferenceEndpointsRequest(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(new ListInferenceEndpointsParametersValidator("requestParameters").optional().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("page_size", requestParameters.getPageSize())
      .build();
  }

  /**
   * Get an Inference Endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @return response of {@code InferenceEndpoint}
   */
  public InferenceEndpoint getInferenceEndpoint(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName
  ) throws ApiException, ValidationException {
    Request request = this.buildGetInferenceEndpointRequest(organizationName, inferenceEndpointName);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpoint>() {});
  }

  /**
   * Get an Inference Endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @return response of {@code CompletableFuture<InferenceEndpoint>}
   */
  public CompletableFuture<InferenceEndpoint> getInferenceEndpointAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName
  ) throws ApiException, ValidationException {
    Request request = this.buildGetInferenceEndpointRequest(organizationName, inferenceEndpointName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpoint>() {})
    );
  }

  private Request buildGetInferenceEndpointRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .build();
  }

  /**
   * List Inference Endpoint Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param requestParameters {@link ListInferenceEndpointJobsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointJobCollection}
   */
  public InferenceEndpointJobCollection listInferenceEndpointJobs(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull ListInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildListInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJobCollection>() {});
  }

  /**
   * List Inference Endpoint Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param requestParameters {@link ListInferenceEndpointJobsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InferenceEndpointJobCollection>}
   */
  public CompletableFuture<InferenceEndpointJobCollection> listInferenceEndpointJobsAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull ListInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildListInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointJobCollection>() {})
    );
  }

  private Request buildListInferenceEndpointJobsRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull ListInferenceEndpointJobsParameters requestParameters
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointName)
      )
      .add(new ListInferenceEndpointJobsParametersValidator("requestParameters").optional().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("page_size", requestParameters.getPageSize())
      .build();
  }

  /**
   * Create a New Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobPrototype {@link InferenceEndpointJobPrototype} Request Body
   * @return response of {@code InferenceEndpointJob}
   */
  public InferenceEndpointJob createInferenceEndpointJob(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull InferenceEndpointJobPrototype inferenceEndpointJobPrototype
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCreateInferenceEndpointJobRequest(
          organizationName,
          inferenceEndpointName,
          inferenceEndpointJobPrototype
        );
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {});
  }

  /**
   * Create a New Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobPrototype {@link InferenceEndpointJobPrototype} Request Body
   * @return response of {@code CompletableFuture<InferenceEndpointJob>}
   */
  public CompletableFuture<InferenceEndpointJob> createInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull InferenceEndpointJobPrototype inferenceEndpointJobPrototype
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCreateInferenceEndpointJobRequest(
          organizationName,
          inferenceEndpointName,
          inferenceEndpointJobPrototype
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {})
    );
  }

  private Request buildCreateInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull InferenceEndpointJobPrototype inferenceEndpointJobPrototype
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointName)
      )
      .add(
        new InferenceEndpointJobPrototypeValidator("inferenceEndpointJobPrototype")
          .required()
          .validate(inferenceEndpointJobPrototype)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setJsonContent(inferenceEndpointJobPrototype)
      .build();
  }

  /**
   * Get an Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobId String The inference endpoint job identifier.
   * @return response of {@code InferenceEndpointJob}
   */
  public InferenceEndpointJob getInferenceEndpointJob(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildGetInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {});
  }

  /**
   * Get an Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobId String The inference endpoint job identifier.
   * @return response of {@code CompletableFuture<InferenceEndpointJob>}
   */
  public CompletableFuture<InferenceEndpointJob> getInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildGetInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {})
    );
  }

  private Request buildGetInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setPathParameter("inference_endpoint_job_id", inferenceEndpointJobId)
      .build();
  }

  /**
   * Cancel an Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobId String The inference endpoint job identifier.
   * @return response of {@code void}
   */
  public void deleteInferenceEndpointJob(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildDeleteInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    this.execute(request);
  }

  /**
   * Cancel an Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param inferenceEndpointJobId String The inference endpoint job identifier.
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildDeleteInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildDeleteInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(organizationName)
      )
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setPathParameter("inference_endpoint_job_id", inferenceEndpointJobId)
      .build();
  }
}
