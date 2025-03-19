package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the operational state of a container group during its lifecycle, including timing information, status, and instance distribution metrics. This state captures the current execution status, start and finish times, and provides visibility into the operational health across instances.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupState {

  /**
   * Timestamp when the container group execution finished or is expected to finish
   */
  @NonNull
  @JsonProperty("finish_time")
  private String finishTime;

  /**
   * A summary of container group instances categorized by their current lifecycle status
   */
  @NonNull
  @JsonProperty("instance_status_counts")
  private ContainerGroupInstanceStatusCount instanceStatusCounts;

  /**
   * Timestamp when the container group execution started
   */
  @NonNull
  @JsonProperty("start_time")
  private String startTime;

  /**
   * Represents the current operational state of a container group within the Salad platform.
   */
  @NonNull
  private ContainerGroupStatus status;

  /**
   * Optional textual description or notes about the current state of the container group
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String description;
}
