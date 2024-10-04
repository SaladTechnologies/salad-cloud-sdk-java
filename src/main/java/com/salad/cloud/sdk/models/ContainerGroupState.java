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
 * Represents a container group state
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupState {

  @NonNull
  private ContainerGroupStatus status;

  @NonNull
  @JsonProperty("start_time")
  private String startTime;

  @NonNull
  @JsonProperty("finish_time")
  private String finishTime;

  /**
   * Represents a container group instance status count
   */
  @NonNull
  @JsonProperty("instance_status_counts")
  private ContainerGroupInstanceStatusCount instanceStatusCounts;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String description;
}
