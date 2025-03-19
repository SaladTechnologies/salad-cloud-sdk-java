package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.ListQueueJobsParameters;
import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueueCollection;
import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobCollection;
import com.salad.cloud.sdk.models.QueueJobPrototype;
import com.salad.cloud.sdk.models.QueuePatch;
import com.salad.cloud.sdk.models.QueuePrototype;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.exceptions.ValidationException;
import com.salad.cloud.sdk.validation.validators.StringValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.ListQueueJobsParametersValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.QueueJobPrototypeValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.QueuePatchValidator;
import com.salad.cloud.sdk.validation.validators.modelValidators.QueuePrototypeValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * QueuesService Service
 */
public class QueuesService extends BaseService {

  public QueuesService(@NonNull OkHttpClient httpClient, SaladCloudSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * List Queues
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code QueueCollection}
   */
  public QueueCollection listQueues(@NonNull String organizationName, @NonNull String projectName)
    throws ApiException, ValidationException {
    Request request = this.buildListQueuesRequest(organizationName, projectName);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<QueueCollection>() {});
  }

  /**
   * List Queues
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code CompletableFuture<QueueCollection>}
   */
  public CompletableFuture<QueueCollection> listQueuesAsync(
    @NonNull String organizationName,
    @NonNull String projectName
  ) throws ApiException, ValidationException {
    Request request = this.buildListQueuesRequest(organizationName, projectName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<QueueCollection>() {})
    );
  }

  private Request buildListQueuesRequest(@NonNull String organizationName, @NonNull String projectName)
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
      .add(
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .build();
  }

  /**
   * Create Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queuePrototype {@link QueuePrototype} Request Body
   * @return response of {@code Queue}
   */
  public Queue createQueue(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull QueuePrototype queuePrototype
  ) throws ApiException, ValidationException {
    Request request = this.buildCreateQueueRequest(organizationName, projectName, queuePrototype);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Create Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queuePrototype {@link QueuePrototype} Request Body
   * @return response of {@code CompletableFuture<Queue>}
   */
  public CompletableFuture<Queue> createQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull QueuePrototype queuePrototype
  ) throws ApiException, ValidationException {
    Request request = this.buildCreateQueueRequest(organizationName, projectName, queuePrototype);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Queue>() {}));
  }

  private Request buildCreateQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull QueuePrototype queuePrototype
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(new QueuePrototypeValidator("queuePrototype").required().validate(queuePrototype))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setJsonContent(queuePrototype)
      .build();
  }

  /**
   * Get Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code Queue}
   */
  public Queue getQueue(@NonNull String organizationName, @NonNull String projectName, @NonNull String queueName)
    throws ApiException, ValidationException {
    Request request = this.buildGetQueueRequest(organizationName, projectName, queueName);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Get Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code CompletableFuture<Queue>}
   */
  public CompletableFuture<Queue> getQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) throws ApiException, ValidationException {
    Request request = this.buildGetQueueRequest(organizationName, projectName, queueName);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Queue>() {}));
  }

  private Request buildGetQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .build();
  }

  /**
   * Update Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queuePatch {@link QueuePatch} Request Body
   * @return response of {@code Queue}
   */
  public Queue updateQueue(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueuePatch queuePatch
  ) throws ApiException, ValidationException {
    Request request = this.buildUpdateQueueRequest(organizationName, projectName, queueName, queuePatch);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Update Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queuePatch {@link QueuePatch} Request Body
   * @return response of {@code CompletableFuture<Queue>}
   */
  public CompletableFuture<Queue> updateQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueuePatch queuePatch
  ) throws ApiException, ValidationException {
    Request request = this.buildUpdateQueueRequest(organizationName, projectName, queueName, queuePatch);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Queue>() {}));
  }

  private Request buildUpdateQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueuePatch queuePatch
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .add(new QueuePatchValidator("queuePatch").required().validate(queuePatch))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PATCH,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setJsonContent(queuePatch, MediaType.parse("application/merge-patch+json"))
      .build();
  }

  /**
   * Delete Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code void}
   */
  public void deleteQueue(@NonNull String organizationName, @NonNull String projectName, @NonNull String queueName)
    throws ApiException, ValidationException {
    Request request = this.buildDeleteQueueRequest(organizationName, projectName, queueName);
    this.execute(request);
  }

  /**
   * Delete Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) throws ApiException, ValidationException {
    Request request = this.buildDeleteQueueRequest(organizationName, projectName, queueName);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildDeleteQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.DELETE,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .build();
  }

  /**
   * List Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param requestParameters {@link ListQueueJobsParameters} Request Parameters Object
   * @return response of {@code QueueJobCollection}
   */
  public QueueJobCollection listQueueJobs(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListQueueJobsRequest(organizationName, projectName, queueName, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<QueueJobCollection>() {});
  }

  /**
   * List Jobs
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param requestParameters {@link ListQueueJobsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<QueueJobCollection>}
   */
  public CompletableFuture<QueueJobCollection> listQueueJobsAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
  ) throws ApiException, ValidationException {
    Request request = this.buildListQueueJobsRequest(organizationName, projectName, queueName, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<QueueJobCollection>() {})
    );
  }

  private Request buildListQueueJobsRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .add(new ListQueueJobsParametersValidator("requestParameters").optional().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("page_size", requestParameters.getPageSize())
      .build();
  }

  /**
   * Create Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobPrototype {@link QueueJobPrototype} Request Body
   * @return response of {@code QueueJob}
   */
  public QueueJob createQueueJob(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueueJobPrototype queueJobPrototype
  ) throws ApiException, ValidationException {
    Request request = this.buildCreateQueueJobRequest(organizationName, projectName, queueName, queueJobPrototype);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<QueueJob>() {});
  }

  /**
   * Create Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobPrototype {@link QueueJobPrototype} Request Body
   * @return response of {@code CompletableFuture<QueueJob>}
   */
  public CompletableFuture<QueueJob> createQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueueJobPrototype queueJobPrototype
  ) throws ApiException, ValidationException {
    Request request = this.buildCreateQueueJobRequest(organizationName, projectName, queueName, queueJobPrototype);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<QueueJob>() {})
    );
  }

  private Request buildCreateQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull QueueJobPrototype queueJobPrototype
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .add(new QueueJobPrototypeValidator("queueJobPrototype").required().validate(queueJobPrototype))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setJsonContent(queueJobPrototype)
      .build();
  }

  /**
   * Get Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code QueueJob}
   */
  public QueueJob getQueueJob(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException, ValidationException {
    Request request = this.buildGetQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<QueueJob>() {});
  }

  /**
   * Get Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code CompletableFuture<QueueJob>}
   */
  public CompletableFuture<QueueJob> getQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException, ValidationException {
    Request request = this.buildGetQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<QueueJob>() {})
    );
  }

  private Request buildGetQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs/{queue_job_id}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setPathParameter("queue_job_id", queueJobId)
      .build();
  }

  /**
   * Delete Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code void}
   */
  public void deleteQueueJob(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException, ValidationException {
    Request request = this.buildDeleteQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    this.execute(request);
  }

  /**
   * Delete Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException, ValidationException {
    Request request = this.buildDeleteQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildDeleteQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
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
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(projectName)
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queueName)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.DELETE,
      this.config.getBaseUrl(),
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs/{queue_job_id}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setPathParameter("queue_job_id", queueJobId)
      .build();
  }
}
