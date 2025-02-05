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
 * Represents the autoscaling rules for a queue
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueAutoscaler {

  /**
   * The minimum number of instances the container can scale down to
   */
  @NonNull
  @JsonProperty("min_replicas")
  private Long minReplicas;

  /**
   * The maximum number of instances the container can scale up to
   */
  @NonNull
  @JsonProperty("max_replicas")
  private Long maxReplicas;

  @NonNull
  @JsonProperty("desired_queue_length")
  private Long desiredQueueLength;

  /**
   * The period (in seconds) in which the queue checks the formula
   */
  @JsonProperty("polling_period")
  private Long pollingPeriod;

  /**
   * The maximum number of instances that can be added per minute
   */
  @JsonProperty("max_upscale_per_minute")
  private Long maxUpscalePerMinute;

  /**
   * The maximum number of instances that can be removed per minute
   */
  @JsonProperty("max_downscale_per_minute")
  private Long maxDownscalePerMinute;
}
