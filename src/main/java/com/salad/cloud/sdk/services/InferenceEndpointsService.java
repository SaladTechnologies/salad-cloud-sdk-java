package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.models.GetInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;
import com.salad.cloud.sdk.models.InferenceEndpointsList;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
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
   * @return response of {@code InferenceEndpointsList}
   */
  public InferenceEndpointsList listInferenceEndpoints(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<InferenceEndpointsList>() {});
  }

  /**
   * List Inference Endpoints
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param requestParameters {@link ListInferenceEndpointsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointsList}
   */
  public CompletableFuture<InferenceEndpointsList> listInferenceEndpointsAsync(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListInferenceEndpointsRequest(organizationName, requestParameters);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<InferenceEndpointsList>() {});
    });
  }

  private Request buildListInferenceEndpointsRequest(
    @NonNull String organizationName,
    @NonNull ListInferenceEndpointsParameters requestParameters
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "organizations/{organization_name}/inference-endpoints")
      .setPathParameter("organization_name", organizationName)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("page_size", requestParameters.getPageSize())
      .build();
  }

  /**
   * Get Inference Endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
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
   * Get Inference Endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @return response of {@code InferenceEndpoint}
   */
  public CompletableFuture<InferenceEndpoint> getInferenceEndpointAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName
  ) throws ApiException, ValidationException {
    Request request = this.buildGetInferenceEndpointRequest(organizationName, inferenceEndpointName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<InferenceEndpoint>() {});
    });
  }

  private Request buildGetInferenceEndpointRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .add(new StringValidator("inferenceEndpointName").minLength(2).maxLength(63), inferenceEndpointName)
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
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param requestParameters {@link GetInferenceEndpointJobsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointJobList}
   */
  public InferenceEndpointJobList getInferenceEndpointJobs(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull GetInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildGetInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<InferenceEndpointJobList>() {});
  }

  /**
   * List Inference Endpoint Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param requestParameters {@link GetInferenceEndpointJobsParameters} Request Parameters Object
   * @return response of {@code InferenceEndpointJobList}
   */
  public CompletableFuture<InferenceEndpointJobList> getInferenceEndpointJobsAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull GetInferenceEndpointJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request =
      this.buildGetInferenceEndpointJobsRequest(organizationName, inferenceEndpointName, requestParameters);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<InferenceEndpointJobList>() {});
    });
  }

  private Request buildGetInferenceEndpointJobsRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull GetInferenceEndpointJobsParameters requestParameters
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .add(new StringValidator("inferenceEndpointName").minLength(2).maxLength(63), inferenceEndpointName)
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
   * Create a new Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
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
   * Create a new Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param createInferenceEndpointJob {@link CreateInferenceEndpointJob} Request Body
   * @return response of {@code InferenceEndpointJob}
   */
  public CompletableFuture<InferenceEndpointJob> createInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull CreateInferenceEndpointJob createInferenceEndpointJob
  ) throws ApiException, ValidationException {
    Request request =
      this.buildCreateInferenceEndpointJobRequest(organizationName, inferenceEndpointName, createInferenceEndpointJob);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<InferenceEndpointJob>() {});
    });
  }

  private Request buildCreateInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull CreateInferenceEndpointJob createInferenceEndpointJob
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .add(new StringValidator("inferenceEndpointName").minLength(2).maxLength(63), inferenceEndpointName)
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
   * Returns a job in an inference endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param inferenceEndpointJobId String The unique job id
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
   * Returns a job in an inference endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param inferenceEndpointJobId String The unique job id
   * @return response of {@code InferenceEndpointJob}
   */
  public CompletableFuture<InferenceEndpointJob> getInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildGetInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<InferenceEndpointJob>() {});
    });
  }

  private Request buildGetInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .add(new StringValidator("inferenceEndpointName").minLength(2).maxLength(63), inferenceEndpointName)
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
   * Delete a job from an inference endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param inferenceEndpointJobId String The unique job id
   * @return response of {@code Void}
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
   * Delete a job from an inference endpoint
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param inferenceEndpointName String The unique inference endpoint name
   * @param inferenceEndpointJobId String The unique job id
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteInferenceEndpointJobAsync(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ApiException, ValidationException {
    Request request =
      this.buildDeleteInferenceEndpointJobRequest(organizationName, inferenceEndpointName, inferenceEndpointJobId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteInferenceEndpointJobRequest(
    @NonNull String organizationName,
    @NonNull String inferenceEndpointName,
    @NonNull String inferenceEndpointJobId
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new StringValidator("organizationName").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        organizationName
      )
      .add(new StringValidator("inferenceEndpointName").minLength(2).maxLength(63), inferenceEndpointName)
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
