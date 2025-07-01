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
 * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupLivenessProbe {

  /**
   * Number of consecutive failures required to consider the probe as failed
   */
  @NonNull
  @Builder.Default
  @JsonProperty("failure_threshold")
  private Long failureThreshold = 3L;

  /**
   * Number of seconds to wait after container start before initiating liveness probes
   */
  @NonNull
  @JsonProperty("initial_delay_seconds")
  private Long initialDelaySeconds;

  /**
   * Frequency in seconds at which the probe should be executed
   */
  @NonNull
  @Builder.Default
  @JsonProperty("period_seconds")
  private Long periodSeconds = 10L;

  /**
   * Number of consecutive successes required to consider the probe successful
   */
  @NonNull
  @Builder.Default
  @JsonProperty("success_threshold")
  private Long successThreshold = 1L;

  /**
   * Number of seconds after which the probe times out if no response is received
   */
  @NonNull
  @Builder.Default
  @JsonProperty("timeout_seconds")
  private Long timeoutSeconds = 30L;

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
  public static class ContainerGroupLivenessProbeBuilder {

    private JsonNullable<ContainerGroupProbeExec> exec = JsonNullable.undefined();

    @JsonProperty("exec")
    public ContainerGroupLivenessProbeBuilder exec(ContainerGroupProbeExec value) {
      if (value == null) {
        throw new IllegalStateException("exec cannot be null");
      }
      this.exec = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupGRpcProbe> grpc = JsonNullable.undefined();

    @JsonProperty("grpc")
    public ContainerGroupLivenessProbeBuilder grpc(ContainerGroupGRpcProbe value) {
      if (value == null) {
        throw new IllegalStateException("grpc cannot be null");
      }
      this.grpc = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupHttpProbeConfiguration> http = JsonNullable.undefined();

    @JsonProperty("http")
    public ContainerGroupLivenessProbeBuilder http(ContainerGroupHttpProbeConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("http cannot be null");
      }
      this.http = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupTcpProbe> tcp = JsonNullable.undefined();

    @JsonProperty("tcp")
    public ContainerGroupLivenessProbeBuilder tcp(ContainerGroupTcpProbe value) {
      if (value == null) {
        throw new IllegalStateException("tcp cannot be null");
      }
      this.tcp = JsonNullable.of(value);
      return this;
    }
  }
}
