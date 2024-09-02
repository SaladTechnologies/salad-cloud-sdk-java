package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstances;
import com.salad.cloud.sdk.models.ContainerGroupList;
import com.salad.cloud.sdk.models.CreateContainerGroup;
import com.salad.cloud.sdk.models.UpdateContainerGroup;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ContainerGroupsService Service
 */
public class ContainerGroupsService extends BaseService {

  public ContainerGroupsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Container Groups
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code ContainerGroupList}
   */
  public ContainerGroupList listContainerGroups(@NonNull String organizationName, @NonNull String projectName)
    throws ApiException {
    Request request = this.buildListContainerGroupsRequest(organizationName, projectName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroupList>() {});
  }

  /**
   * List Container Groups
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @return response of {@code ContainerGroupList}
   */
  public CompletableFuture<ContainerGroupList> listContainerGroupsAsync(
    @NonNull String organizationName,
    @NonNull String projectName
  ) throws ApiException {
    Request request = this.buildListContainerGroupsRequest(organizationName, projectName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroupList>() {});
    });
  }

  private Request buildListContainerGroupsRequest(@NonNull String organizationName, @NonNull String projectName) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .build();
  }

  /**
   * Create a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param createContainerGroup {@link CreateContainerGroup} Request Body
   * @return response of {@code ContainerGroup}
   */
  public ContainerGroup createContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateContainerGroup createContainerGroup
  ) throws ApiException {
    Request request = this.buildCreateContainerGroupRequest(organizationName, projectName, createContainerGroup);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroup>() {});
  }

  /**
   * Create a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param createContainerGroup {@link CreateContainerGroup} Request Body
   * @return response of {@code ContainerGroup}
   */
  public CompletableFuture<ContainerGroup> createContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateContainerGroup createContainerGroup
  ) throws ApiException {
    Request request = this.buildCreateContainerGroupRequest(organizationName, projectName, createContainerGroup);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroup>() {});
    });
  }

  private Request buildCreateContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull CreateContainerGroup createContainerGroup
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setJsonContent(createContainerGroup)
      .build();
  }

  /**
   * Get a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code ContainerGroup}
   */
  public ContainerGroup getContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildGetContainerGroupRequest(organizationName, projectName, containerGroupName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroup>() {});
  }

  /**
   * Get a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code ContainerGroup}
   */
  public CompletableFuture<ContainerGroup> getContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildGetContainerGroupRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroup>() {});
    });
  }

  private Request buildGetContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }

  /**
   * Update a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param updateContainerGroup {@link UpdateContainerGroup} Request Body
   * @return response of {@code ContainerGroup}
   */
  public ContainerGroup updateContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull UpdateContainerGroup updateContainerGroup
  ) throws ApiException {
    Request request =
      this.buildUpdateContainerGroupRequest(organizationName, projectName, containerGroupName, updateContainerGroup);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroup>() {});
  }

  /**
   * Update a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param updateContainerGroup {@link UpdateContainerGroup} Request Body
   * @return response of {@code ContainerGroup}
   */
  public CompletableFuture<ContainerGroup> updateContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull UpdateContainerGroup updateContainerGroup
  ) throws ApiException {
    Request request =
      this.buildUpdateContainerGroupRequest(organizationName, projectName, containerGroupName, updateContainerGroup);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroup>() {});
    });
  }

  private Request buildUpdateContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull UpdateContainerGroup updateContainerGroup
  ) {
    return new RequestBuilder(
      HttpMethod.PATCH,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .setJsonContent(updateContainerGroup, MediaType.parse("application/merge-patch+json"))
      .build();
  }

  /**
   * Delete a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public void deleteContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildDeleteContainerGroupRequest(organizationName, projectName, containerGroupName);
    this.execute(request);
  }

  /**
   * Delete a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildDeleteContainerGroupRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }

  /**
   * Start a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public void startContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildStartContainerGroupRequest(organizationName, projectName, containerGroupName);
    this.execute(request);
  }

  /**
   * Start a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> startContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildStartContainerGroupRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildStartContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/start"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }

  /**
   * Stop a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public void stopContainerGroup(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildStopContainerGroupRequest(organizationName, projectName, containerGroupName);
    this.execute(request);
  }

  /**
   * Stop a Container Group
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> stopContainerGroupAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildStopContainerGroupRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildStopContainerGroupRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/stop"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }

  /**
   * List Container Group Instances
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code ContainerGroupInstances}
   */
  public ContainerGroupInstances listContainerGroupInstances(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildListContainerGroupInstancesRequest(organizationName, projectName, containerGroupName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroupInstances>() {});
  }

  /**
   * List Container Group Instances
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @return response of {@code ContainerGroupInstances}
   */
  public CompletableFuture<ContainerGroupInstances> listContainerGroupInstancesAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) throws ApiException {
    Request request = this.buildListContainerGroupInstancesRequest(organizationName, projectName, containerGroupName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroupInstances>() {});
    });
  }

  private Request buildListContainerGroupInstancesRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .build();
  }

  /**
   * Get Container Group Instance by instance ID
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code ContainerGroupInstance}
   */
  public ContainerGroupInstance getContainerGroupInstance(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildGetContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerGroupInstance>() {});
  }

  /**
   * Get Container Group Instance by instance ID
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code ContainerGroupInstance}
   */
  public CompletableFuture<ContainerGroupInstance> getContainerGroupInstanceAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildGetContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerGroupInstance>() {});
    });
  }

  private Request buildGetContainerGroupInstanceRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .setPathParameter("container_group_instance_id", containerGroupInstanceId)
      .build();
  }

  /**
   * Reallocate container group instance to another node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public void reallocateContainerGroupInstance(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildReallocateContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    this.execute(request);
  }

  /**
   * Reallocate container group instance to another node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> reallocateContainerGroupInstanceAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildReallocateContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildReallocateContainerGroupInstanceRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/reallocate"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .setPathParameter("container_group_instance_id", containerGroupInstanceId)
      .build();
  }

  /**
   * Recreate container on a node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public void recreateContainerGroupInstance(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildRecreateContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    this.execute(request);
  }

  /**
   * Recreate container on a node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> recreateContainerGroupInstanceAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildRecreateContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildRecreateContainerGroupInstanceRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/recreate"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .setPathParameter("container_group_instance_id", containerGroupInstanceId)
      .build();
  }

  /**
   * Restart container on a node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public void restartContainerGroupInstance(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildRestartContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    this.execute(request);
  }

  /**
   * Restart container on a node
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @param projectName String Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.
   * @param containerGroupName String The unique container group name
   * @param containerGroupInstanceId String The unique instance identifier
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> restartContainerGroupInstanceAsync(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) throws ApiException {
    Request request =
      this.buildRestartContainerGroupInstanceRequest(
          organizationName,
          projectName,
          containerGroupName,
          containerGroupInstanceId
        );
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildRestartContainerGroupInstanceRequest(
    @NonNull String organizationName,
    @NonNull String projectName,
    @NonNull String containerGroupName,
    @NonNull String containerGroupInstanceId
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      this.serverUrl,
      "organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/restart"
    )
      .setPathParameter("organization_name", organizationName)
      .setPathParameter("project_name", projectName)
      .setPathParameter("container_group_name", containerGroupName)
      .setPathParameter("container_group_instance_id", containerGroupInstanceId)
      .build();
  }
}