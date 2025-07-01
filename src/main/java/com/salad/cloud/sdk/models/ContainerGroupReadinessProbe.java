package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

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
  @JsonProperty("exec")
  private JsonNullable<ContainerGroupProbeExec> exec;

  /**
   * Configuration for gRPC-based health probes in container groups, used to determine container health status.
   */
  @JsonProperty("grpc")
  private JsonNullable<ContainerGroupGRpcProbe> grpc;

  /**
   * Defines HTTP probe configuration for container health checks within a container group.
   */
  @JsonProperty("http")
  private JsonNullable<ContainerGroupHttpProbeConfiguration> http;

  /**
   * Configuration for a TCP probe used to check container health via network connectivity.
   */
  @JsonProperty("tcp")
  private JsonNullable<ContainerGroupTcpProbe> tcp;

  @JsonIgnore
  public ContainerGroupProbeExec getExec() {
    return exec.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupGRpcProbe getGrpc() {
    return grpc.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupHttpProbeConfiguration getHttp() {
    return http.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupTcpProbe getTcp() {
    return tcp.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupReadinessProbeBuilder {

    private JsonNullable<ContainerGroupProbeExec> exec = JsonNullable.undefined();

    @JsonProperty("exec")
    public ContainerGroupReadinessProbeBuilder exec(ContainerGroupProbeExec value) {
      if (value == null) {
        throw new IllegalStateException("exec cannot be null");
      }
      this.exec = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupGRpcProbe> grpc = JsonNullable.undefined();

    @JsonProperty("grpc")
    public ContainerGroupReadinessProbeBuilder grpc(ContainerGroupGRpcProbe value) {
      if (value == null) {
        throw new IllegalStateException("grpc cannot be null");
      }
      this.grpc = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupHttpProbeConfiguration> http = JsonNullable.undefined();

    @JsonProperty("http")
    public ContainerGroupReadinessProbeBuilder http(ContainerGroupHttpProbeConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("http cannot be null");
      }
      this.http = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupTcpProbe> tcp = JsonNullable.undefined();

    @JsonProperty("tcp")
    public ContainerGroupReadinessProbeBuilder tcp(ContainerGroupTcpProbe value) {
      if (value == null) {
        throw new IllegalStateException("tcp cannot be null");
      }
      this.tcp = JsonNullable.of(value);
      return this;
    }
  }
}
