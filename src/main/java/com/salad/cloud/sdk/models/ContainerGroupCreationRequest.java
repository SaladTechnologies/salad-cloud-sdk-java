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
 * Represents a request to create a container group, which manages a collection of container instances with shared configuration and scaling policies
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupCreationRequest {

  /**
   * Determines whether the container group should start automatically when created (true) or remain stopped until manually started (false)
   */
  @NonNull
  @JsonProperty("autostart_policy")
  private Boolean autostartPolicy;

  /**
   * Configuration for creating a container within a container group. Defines the container image, resource requirements, environment variables, and other settings needed to deploy and run the container.
   */
  @NonNull
  private ContainerConfiguration container;

  /**
   * Unique identifier for the container group that must follow DNS naming conventions (lowercase alphanumeric with hyphens)
   */
  @NonNull
  private String name;

  /**
   * Number of container instances to deploy and maintain for this container group
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
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * Human-readable name for the container group that can include spaces and special characters, used for display purposes
   */
  @JsonProperty("display_name")
  private String displayName;

  /**
   * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("liveness_probe")
  private ContainerGroupLivenessProbe livenessProbe;

  /**
   * Network configuration for container groups specifying connectivity parameters, including authentication, protocol, and timeout settings
   */
  private CreateContainerGroupNetworking networking;

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
}
