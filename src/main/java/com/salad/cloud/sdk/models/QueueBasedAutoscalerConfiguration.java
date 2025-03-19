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
 * Defines configuration for automatically scaling container instances based on queue length. The autoscaler monitors a queue and adjusts the number of running replicas to maintain the desired queue length.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueBasedAutoscalerConfiguration {

  /**
   * The target number of items in the queue that the autoscaler attempts to maintain by scaling the containers up or down
   */
  @NonNull
  @JsonProperty("desired_queue_length")
  private Long desiredQueueLength;

  /**
   * The maximum number of instances the container can scale up to
   */
  @NonNull
  @JsonProperty("max_replicas")
  private Long maxReplicas;

  /**
   * The minimum number of instances the container can scale down to, ensuring baseline availability
   */
  @NonNull
  @JsonProperty("min_replicas")
  private Long minReplicas;

  /**
   * The maximum number of instances that can be removed per minute to prevent rapid downscaling
   */
  @JsonProperty("max_downscale_per_minute")
  private Long maxDownscalePerMinute;

  /**
   * The maximum number of instances that can be added per minute to prevent rapid upscaling
   */
  @JsonProperty("max_upscale_per_minute")
  private Long maxUpscalePerMinute;

  /**
   * The period (in seconds) in which the autoscaler checks the queue length and applies the scaling formula
   */
  @JsonProperty("polling_period")
  private Long pollingPeriod;
}
