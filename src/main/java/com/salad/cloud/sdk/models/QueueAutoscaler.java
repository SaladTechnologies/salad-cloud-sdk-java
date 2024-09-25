package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the autoscaling rules for a queue
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueAutoscaler {

  @NonNull
  @JsonProperty("min_replicas")
  private Long minReplicas;

  @NonNull
  @JsonProperty("max_replicas")
  private Long maxReplicas;

  @NonNull
  @JsonProperty("desired_queue_length")
  private Long desiredQueueLength;

  @JsonProperty("polling_period")
  private Long pollingPeriod;

  @JsonProperty("max_upscale_per_minute")
  private Long maxUpscalePerMinute;

  @JsonProperty("max_downscale_per_minute")
  private Long maxDownscalePerMinute;
}
