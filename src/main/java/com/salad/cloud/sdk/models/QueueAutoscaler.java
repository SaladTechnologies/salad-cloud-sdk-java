package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
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
  @Max(100)
  @Min(0)
  @JsonProperty("min_replicas")
  private Long minReplicas;

  @NonNull
  @Max(100)
  @Min(1)
  @JsonProperty("max_replicas")
  private Long maxReplicas;

  @NonNull
  @Max(100)
  @Min(1)
  @JsonProperty("desired_queue_length")
  private Long desiredQueueLength;

  @Max(1800)
  @Min(15)
  @JsonProperty("polling_period")
  private Long pollingPeriod;

  @Max(100)
  @Min(1)
  @JsonProperty("max_upscale_per_minute")
  private Long maxUpscalePerMinute;

  @Max(100)
  @Min(1)
  @JsonProperty("max_downscale_per_minute")
  private Long maxDownscalePerMinute;
}
