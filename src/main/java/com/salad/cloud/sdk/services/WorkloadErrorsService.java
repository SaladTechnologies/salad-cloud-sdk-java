package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.WorkloadErrorList;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * WorkloadErrorsService Service
 */
public class WorkloadErrorsService extends BaseService {

  public WorkloadErrorsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Get workload errors
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code WorkloadErrorList}
   */
  public WorkloadErrorList getWorkloadErrors(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildGetWorkloadErrorsRequest(organizationName, projectName, containerGroupName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<WorkloadErrorList>() {});
  }

  /**
   * Get workload errors
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code WorkloadErrorList}
   */
  public CompletableFuture<WorkloadErrorList> getWorkloadErrorsAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildGetWorkloadErrorsRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<WorkloadErrorList>() {});
    });
  }

  private Request buildGetWorkloadErrorsRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/errors"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }
}
