package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to update a container group
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupPatch {

  /**
   * The display name for the container group. If null is provided, the display name will be set to the container group name.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("display_name")
  private String displayName;

  /**
   * Represents an update container object
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private UpdateContainer container;

  /**
   * The desired number of instances for your container group deployment.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long replicas;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * Represents update container group networking parameters
   */
  private UpdateContainerGroupNetworking networking;

  /**
   * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("liveness_probe")
  private ContainerGroupLivenessProbe livenessProbe;

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

  /**
   * Defines configuration for automatically scaling container instances based on queue length. The autoscaler monitors a queue and adjusts the number of running replicas to maintain the desired queue length.
   */
  @JsonProperty("queue_autoscaler")
  private QueueBasedAutoscalerConfiguration queueAutoscaler;
}
