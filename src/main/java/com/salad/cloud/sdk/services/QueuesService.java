package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.CreateQueue;
import com.salad.cloud.sdk.models.CreateQueueJob;
import com.salad.cloud.sdk.models.ListQueueJobsParameters;
import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobList;
import com.salad.cloud.sdk.models.QueueList;
import com.salad.cloud.sdk.models.UpdateQueue;
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

  public QueuesService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Queues
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code QueueList}
   */
  public QueueList listQueues(@NonNull String organizationName, @NonNull String projectName) throws ApiException {
    Request request = this.buildListQueuesRequest(organizationName, projectName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<QueueList>() {});
  }

  /**
   * List Queues
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code QueueList}
   */
  public CompletableFuture<QueueList> listQueuesAsync(@NonNull String organizationName, @NonNull String projectName)
    throws ApiException {
    Request request = this.buildListQueuesRequest(organizationName, projectName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<QueueList>() {});
    });
  }

  private Request buildListQueuesRequest(@NonNull String organizationName, @NonNull String projectName) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .build();
  }

  /**
   * Create a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param createQueue {@link CreateQueue} Request Body
   * @return response of {@code Queue}
   */
  public Queue createQueue(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateQueue createQueue
  ) throws ApiException {
    Request request = this.buildCreateQueueRequest(organizationName, projectName, createQueue);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Create a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param createQueue {@link CreateQueue} Request Body
   * @return response of {@code Queue}
   */
  public CompletableFuture<Queue> createQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateQueue createQueue
  ) throws ApiException {
    Request request = this.buildCreateQueueRequest(organizationName, projectName, createQueue);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<Queue>() {});
    });
  }

  private Request buildCreateQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateQueue createQueue
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setJsonContent(createQueue)
      .build();
  }

  /**
   * Get a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code Queue}
   */
  public Queue getQueue(@NonNull String organizationName, @NonNull String projectName, @NonNull String queueName)
    throws ApiException {
    Request request = this.buildGetQueueRequest(organizationName, projectName, queueName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Get a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code Queue}
   */
  public CompletableFuture<Queue> getQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) throws ApiException {
    Request request = this.buildGetQueueRequest(organizationName, projectName, queueName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<Queue>() {});
    });
  }

  private Request buildGetQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .build();
  }

  /**
   * Update a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param updateQueue {@link UpdateQueue} Request Body
   * @return response of {@code Queue}
   */
  public Queue updateQueue(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull UpdateQueue updateQueue
  ) throws ApiException {
    Request request = this.buildUpdateQueueRequest(organizationName, projectName, queueName, updateQueue);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Queue>() {});
  }

  /**
   * Update a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param updateQueue {@link UpdateQueue} Request Body
   * @return response of {@code Queue}
   */
  public CompletableFuture<Queue> updateQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull UpdateQueue updateQueue
  ) throws ApiException {
    Request request = this.buildUpdateQueueRequest(organizationName, projectName, queueName, updateQueue);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<Queue>() {});
    });
  }

  private Request buildUpdateQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull UpdateQueue updateQueue
  ) {
    return new RequestBuilder(
      HttpMethod.PATCH,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setJsonContent(updateQueue, MediaType.parse("application/merge-patch+json"))
      .build();
  }

  /**
   * Delete a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code Void}
   */
  public void deleteQueue(@NonNull String organizationName, @NonNull String projectName, @NonNull String queueName)
    throws ApiException {
    Request request = this.buildDeleteQueueRequest(organizationName, projectName, queueName);
    this.execute(request);
  }

  /**
   * Delete a Queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteQueueAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) throws ApiException {
    Request request = this.buildDeleteQueueRequest(organizationName, projectName, queueName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteQueueRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .build();
  }

  /**
   * List Jobs in a Queue that match the paginated query parameters. If no paginated query\nparameters are provided, the full list is returned.
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param requestParameters {@link ListQueueJobsParameters} Request Parameters Object
   * @return response of {@code QueueJobList}
   */
  public QueueJobList listQueueJobs(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildListQueueJobsRequest(organizationName, projectName, queueName, requestParameters);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<QueueJobList>() {});
  }

  /**
   * List Jobs in a Queue that match the paginated query parameters. If no paginated query\nparameters are provided, the full list is returned.
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param requestParameters {@link ListQueueJobsParameters} Request Parameters Object
   * @return response of {@code QueueJobList}
   */
  public CompletableFuture<QueueJobList> listQueueJobsAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildListQueueJobsRequest(organizationName, projectName, queueName, requestParameters);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<QueueJobList>() {});
    });
  }

  private Request buildListQueueJobsRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull ListQueueJobsParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("page_size", requestParameters.getPageSize())
      .build();
  }

  /**
   * Create a new Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param createQueueJob {@link CreateQueueJob} Request Body
   * @return response of {@code QueueJob}
   */
  public QueueJob createQueueJob(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull CreateQueueJob createQueueJob
  ) throws ApiException {
    Request request = this.buildCreateQueueJobRequest(organizationName, projectName, queueName, createQueueJob);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<QueueJob>() {});
  }

  /**
   * Create a new Job
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param createQueueJob {@link CreateQueueJob} Request Body
   * @return response of {@code QueueJob}
   */
  public CompletableFuture<QueueJob> createQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull CreateQueueJob createQueueJob
  ) throws ApiException {
    Request request = this.buildCreateQueueJobRequest(organizationName, projectName, queueName, createQueueJob);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<QueueJob>() {});
    });
  }

  private Request buildCreateQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull CreateQueueJob createQueueJob
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setJsonContent(createQueueJob)
      .build();
  }

  /**
   * Returns a job in a queue
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
  ) throws ApiException {
    Request request = this.buildGetQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<QueueJob>() {});
  }

  /**
   * Returns a job in a queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code QueueJob}
   */
  public CompletableFuture<QueueJob> getQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException {
    Request request = this.buildGetQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<QueueJob>() {});
    });
  }

  private Request buildGetQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs/{queue_job_id}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setPathParameter("queue_job_id", queueJobId)
      .build();
  }

  /**
   * Delete a job from a queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code Void}
   */
  public void deleteQueueJob(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException {
    Request request = this.buildDeleteQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    this.execute(request);
  }

  /**
   * Delete a job from a queue
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param queueName String The queue name.
   * @param queueJobId String The job identifier. This is automatically generated and assigned when the job is created.
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteQueueJobAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) throws ApiException {
    Request request = this.buildDeleteQueueJobRequest(organizationName, projectName, queueName, queueJobId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteQueueJobRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String queueName,
    @NonNull String queueJobId
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/queues/{queue_name}/jobs/{queue_job_id}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("queue_name", queueName)
      .setPathParameter("queue_job_id", queueJobId)
      .build();
  }
}