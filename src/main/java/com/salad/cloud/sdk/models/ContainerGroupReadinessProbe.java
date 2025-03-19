package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Defines how to check if a container is ready to serve traffic. The readiness probe determines whether the container's application is ready to accept traffic. If the readiness probe fails, the container is considered not ready and traffic will not be sent to it.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupReadinessProbe {

  /**
   * The number of consecutive failures required to consider the probe failed. After this many consecutive failures, the container is marked as not ready.
   */
  @NonNull
  @Builder.Default
  @JsonProperty("failure_threshold")
  private Long failureThreshold = 3L;

  /**
   * The time in seconds to wait after the container starts before initiating the first probe. This allows time for the application to initialize before being tested.
   */
  @NonNull
  @JsonProperty("initial_delay_seconds")
  private Long initialDelaySeconds;

  /**
   * How frequently (in seconds) the probe should be executed during the container's lifetime. Specifies the interval between consecutive probe executions.
   */
  @NonNull
  @Builder.Default
  @JsonProperty("period_seconds")
  private Long periodSeconds = 1L;

  /**
   * The minimum consecutive successes required to consider the probe successful after it has failed. Defines how many successful probe results are needed to transition from failure to success.
   */
  @NonNull
  @Builder.Default
  @JsonProperty("success_threshold")
  private Long successThreshold = 1L;

  /**
   * The maximum time in seconds that the probe has to complete. If the probe doesn't return a result before the timeout, it's considered failed.
   */
  @NonNull
  @Builder.Default
  @JsonProperty("timeout_seconds")
  private Long timeoutSeconds = 1L;

  /**
   * Defines the exec action for a probe in a container group. This is used to execute a command inside a container for health checks.
   */
  private ContainerGroupProbeExec exec;

  /**
   * Configuration for gRPC-based health probes in container groups, used to determine container health status.
   */
  private ContainerGroupGRpcProbe grpc;

  /**
   * Defines HTTP probe configuration for container health checks within a container group.
   */
  private ContainerGroupHttpProbeConfiguration http;

  /**
   * Configuration for a TCP probe used to check container health via network connectivity.
   */
  private ContainerGroupTcpProbe tcp;
}
