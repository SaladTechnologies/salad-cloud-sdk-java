package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * A container group definition that represents a scalable set of identical containers running as a distributed service
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroup {

  /**
   * Defines whether containers in this group should automatically start when deployed (true) or require manual starting (false)
   */
  @NonNull
  @JsonProperty("autostart_policy")
  private Boolean autostartPolicy;

  /**
   * Represents a container with its configuration and resource requirements.
   */
  @NonNull
  private Container container;

  /**
   * List of country codes where container instances are permitted to run. When not specified or empty, containers may run in any available region.
   */
  @NonNull
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * ISO 8601 timestamp when this container group was initially created
   */
  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  /**
   * Represents the operational state of a container group during its lifecycle, including timing information, status, and instance distribution metrics. This state captures the current execution status, start and finish times, and provides visibility into the operational health across instances.
   */
  @NonNull
  @JsonProperty("current_state")
  private ContainerGroupState currentState;

  /**
   * The display-friendly name of the resource.
   */
  @NonNull
  @JsonProperty("display_name")
  private String displayName;

  /**
   * The container group identifier.
   */
  @NonNull
  private String id;

  /**
   * The container group name.
   */
  @NonNull
  private String name;

  /**
   * The organization name.
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  /**
   * Indicates whether a configuration change has been requested but not yet applied to all containers in the group
   */
  @NonNull
  @JsonProperty("pending_change")
  private Boolean pendingChange;

  /**
   * Specifies the priority level for container group execution, which determines resource allocation and scheduling precedence.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  /**
   * The project name.
   */
  @NonNull
  @JsonProperty("project_name")
  private String projectName;

  /**
   * The container group replicas.
   */
  @NonNull
  private Long replicas;

  /**
   * Specifies the policy for restarting containers when they exit or fail.
   */
  @NonNull
  @JsonProperty("restart_policy")
  private ContainerRestartPolicy restartPolicy;

  /**
   * ISO 8601 timestamp when this container group was last updated
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * Incremental version number that increases with each configuration change to the container group
   */
  @NonNull
  private Long version;

  /**
   * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("liveness_probe")
  private ContainerGroupLivenessProbe livenessProbe;

  /**
   * Network configuration for container groups that defines connectivity, routing, and access control settings
   */
  private ContainerGroupNetworkingConfiguration networking;

  /**
   * Defines configuration for automatically scaling container instances based on queue length. The autoscaler monitors a queue and adjusts the number of running replicas to maintain the desired queue length.
   */
  @JsonProperty("queue_autoscaler")
  private QueueBasedAutoscalerConfiguration queueAutoscaler;

  /**
   * Configuration for connecting a container group to a message queue system, enabling asynchronous communication between services.
   */
  @JsonProperty("queue_connection")
  private ContainerGroupQueueConnection queueConnection;

  /**
   * Defines how to check if a container is ready to serve traffic. The readiness probe determines whether the container's application is ready to accept traffic. If the readiness probe fails, the container is considered not ready and traffic will not be sent to it.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("readiness_probe")
  private ContainerGroupReadinessProbe readinessProbe;

  /**
   * Defines a probe that checks if a container application has started successfully. Startup probes help prevent applications from being prematurely marked as unhealthy during initialization. The probe can use HTTP requests, TCP connections, gRPC calls, or shell commands to determine startup status.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("startup_probe")
  private ContainerGroupStartupProbe startupProbe;

  // Overwrite lombok builder methods
  public static class ContainerGroupBuilder {

    /**
     * Flag to track if the priority property has been set.
     */
    private boolean priority$set = false;

    public ContainerGroupBuilder priority(ContainerGroupPriority priority) {
      this.priority$set = true;
      this.priority = priority;
      return this;
    }

    public ContainerGroup build() {
      if (!priority$set) {
        throw new IllegalStateException("priority is required");
      }
      return new ContainerGroup(
        autostartPolicy,
        container,
        countryCodes,
        createTime,
        currentState,
        displayName,
        id,
        name,
        organizationName,
        pendingChange,
        priority,
        projectName,
        replicas,
        restartPolicy,
        updateTime,
        version,
        livenessProbe,
        networking,
        queueAutoscaler,
        queueConnection,
        readinessProbe,
        startupProbe
      );
    }
  }
}
