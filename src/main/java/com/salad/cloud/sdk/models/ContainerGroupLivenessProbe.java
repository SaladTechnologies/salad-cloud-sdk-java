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
 * Represents the container group liveness probe
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupLivenessProbe {

  @NonNull
  @JsonProperty("initial_delay_seconds")
  private Long initialDelaySeconds;

  @NonNull
  @Builder.Default
  @JsonProperty("period_seconds")
  private Long periodSeconds = 10L;

  @NonNull
  @Builder.Default
  @JsonProperty("timeout_seconds")
  private Long timeoutSeconds = 30L;

  @NonNull
  @Builder.Default
  @JsonProperty("success_threshold")
  private Long successThreshold = 1L;

  @NonNull
  @Builder.Default
  @JsonProperty("failure_threshold")
  private Long failureThreshold = 3L;

  private ContainerGroupProbeTcp tcp;

  private ContainerGroupProbeHttp http;

  private ContainerGroupProbeGrpc grpc;

  private ContainerGroupProbeExec exec;
}
