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
 * A summary of container group instances categorized by their current lifecycle status
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstanceStatusCount {

  /**
   * The number of container instances that are currently being allocated resources
   */
  @NonNull
  @JsonProperty("allocating_count")
  private Long allocatingCount;

  /**
   * The number of container instances that are in the process of being created
   */
  @NonNull
  @JsonProperty("creating_count")
  private Long creatingCount;

  /**
   * The number of container instances that are currently running and operational
   */
  @NonNull
  @JsonProperty("running_count")
  private Long runningCount;

  /**
   * The number of container instances that are in the process of stopping
   */
  @NonNull
  @JsonProperty("stopping_count")
  private Long stoppingCount;
}
