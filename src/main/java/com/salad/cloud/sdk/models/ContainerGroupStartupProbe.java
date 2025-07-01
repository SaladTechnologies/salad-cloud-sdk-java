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
 * Defines a probe that checks if a container application has started successfully. Startup probes help prevent applications from being prematurely marked as unhealthy during initialization. The probe can use HTTP requests, TCP connections, gRPC calls, or shell commands to determine startup status.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupStartupProbe {

  /**
   * Number of times the probe must fail before considering the container not started
   */
  @NonNull
  @Builder.Default
  @JsonProperty("failure_threshold")
  private Long failureThreshold = 15L;

  /**
   * Number of seconds to wait after container startup before the first probe is executed
   */
  @NonNull
  @JsonProperty("initial_delay_seconds")
  private Long initialDelaySeconds;

  /**
   * How frequently (in seconds) to perform the probe
   */
  @NonNull
  @Builder.Default
  @JsonProperty("period_seconds")
  private Long periodSeconds = 3L;

  /**
   * Minimum consecutive successes required for the probe to be considered successful
   */
  @NonNull
  @Builder.Default
  @JsonProperty("success_threshold")
  private Long successThreshold = 2L;

  /**
   * Maximum time (in seconds) to wait for a probe response before considering it failed
   */
  @NonNull
  @Builder.Default
  @JsonProperty("timeout_seconds")
  private Long timeoutSeconds = 10L;

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
  public static class ContainerGroupStartupProbeBuilder {

    private JsonNullable<ContainerGroupProbeExec> exec = JsonNullable.undefined();

    @JsonProperty("exec")
    public ContainerGroupStartupProbeBuilder exec(ContainerGroupProbeExec value) {
      if (value == null) {
        throw new IllegalStateException("exec cannot be null");
      }
      this.exec = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupGRpcProbe> grpc = JsonNullable.undefined();

    @JsonProperty("grpc")
    public ContainerGroupStartupProbeBuilder grpc(ContainerGroupGRpcProbe value) {
      if (value == null) {
        throw new IllegalStateException("grpc cannot be null");
      }
      this.grpc = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupHttpProbeConfiguration> http = JsonNullable.undefined();

    @JsonProperty("http")
    public ContainerGroupStartupProbeBuilder http(ContainerGroupHttpProbeConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("http cannot be null");
      }
      this.http = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupTcpProbe> tcp = JsonNullable.undefined();

    @JsonProperty("tcp")
    public ContainerGroupStartupProbeBuilder tcp(ContainerGroupTcpProbe value) {
      if (value == null) {
        throw new IllegalStateException("tcp cannot be null");
      }
      this.tcp = JsonNullable.of(value);
      return this;
    }
  }
}
