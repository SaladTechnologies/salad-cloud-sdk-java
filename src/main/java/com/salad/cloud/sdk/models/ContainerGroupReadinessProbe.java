package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Min;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the container group readiness probe
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupReadinessProbe {

  @NonNull
  @Min(0)
  @JsonProperty("initial_delay_seconds")
  private Long initialDelaySeconds;

  @NonNull
  @Min(1)
  @Builder.Default
  @JsonProperty("period_seconds")
  private Long periodSeconds = 1L;

  @NonNull
  @Min(1)
  @Builder.Default
  @JsonProperty("timeout_seconds")
  private Long timeoutSeconds = 1L;

  @NonNull
  @Min(1)
  @Builder.Default
  @JsonProperty("success_threshold")
  private Long successThreshold = 1L;

  @NonNull
  @Min(1)
  @Builder.Default
  @JsonProperty("failure_threshold")
  private Long failureThreshold = 3L;

  private ContainerGroupProbeTcp tcp;

  private ContainerGroupProbeHttp http;

  private ContainerGroupProbeGrpc grpc;

  private ContainerGroupProbeExec exec;
}
