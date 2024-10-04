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
 * Represents a container group instance status count
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstanceStatusCount {

  @NonNull
  @JsonProperty("allocating_count")
  private Long allocatingCount;

  @NonNull
  @JsonProperty("creating_count")
  private Long creatingCount;

  @NonNull
  @JsonProperty("running_count")
  private Long runningCount;

  @NonNull
  @JsonProperty("stopping_count")
  private Long stoppingCount;
}
