package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;
import com.salad.cloud.sdk.models.InferenceEndpointList;
import com.salad.cloud.sdk.models.ListInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.CreateInferenceEndpointJobValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.ListInferenceEndpointJobsParametersValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.ListInferenceEndpointsParametersValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * InferenceEndpointsService Service
 */
public class InferenceEndpointsService extends BaseService {

  public InferenceEndpointsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Inference Endpoints
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param requestParameters {@link ListInferenceEndpointsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointList}
   */
  public InferenceEndpointList listInferenceEndpoints(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointList>() {});
  }

  /**
   * List Inference Endpoints
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param requestParameters {@link ListInferenceEndpointsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InferenceEndpointList>}
   */
  public CompletableFuture<InferenceEndpointList> listInferenceEndpointsAsync(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointList>() {})
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
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "organizations/{organization_name}/inference-endpoints")
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
      this.serverUrl,
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}"
    )
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
   * @return response of {@code InferenceEndpointJobList}
   */
  public InferenceEndpointJobList listInferenceEndpointJobs(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull ListInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildListInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJobList>() {});
  }

  /**
   * List Inference Endpoint Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param requestParameters {@link ListInferenceEndpointJobsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InferenceEndpointJobList>}
   */
  public CompletableFuture<InferenceEndpointJobList> listInferenceEndpointJobsAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull ListInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildListInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointJobList>() {})
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
      this.serverUrl,
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs"
    )
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
   * @param createInferenceEndpointJob {@link CreateInferenceEndpointJob} Request Body
   * @return response of {@code InferenceEndpointJob}
   */
  public InferenceEndpointJob createInferenceEndpointJob(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull CreateInferenceEndpointJob createInferenceEndpointJob
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCreateInferenceEndpointJobRequest(organizationName, inferenceEndpointName, createInferenceEndpointJob);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {});
  }

  /**
   * Create a New Inference Endpoint Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The inference endpoint name.
   * @param createInferenceEndpointJob {@link CreateInferenceEndpointJob} Request Body
   * @return response of {@code CompletableFuture<InferenceEndpointJob>}
   */
  public CompletableFuture<InferenceEndpointJob> createInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull CreateInferenceEndpointJob createInferenceEndpointJob
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCreateInferenceEndpointJobRequest(organizationName, inferenceEndpointName, createInferenceEndpointJob);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InferenceEndpointJob>() {})
    );
  }

  private Request buildCreateInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull CreateInferenceEndpointJob createInferenceEndpointJob
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
        new CreateInferenceEndpointJobValidator("createInferenceEndpointJob")
          .required()
          .validate(createInferenceEndpointJob)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setJsonContent(createInferenceEndpointJob)
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
      this.serverUrl,
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}"
    )
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
  public void cancelInferenceEndpointJob(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCancelInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
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
  public CompletableFuture<Void> cancelInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCancelInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildCancelInferenceEndpointJobRequest(
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
      this.serverUrl,
      "organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("inference_endpoint_name", inferenceEndpointName)
      .setPathParameter("inference_endpoint_job_id", inferenceEndpointJobId)
      .build();
  }
}
