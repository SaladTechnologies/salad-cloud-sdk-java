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
 * Represents a container group instance status count
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstanceStatusCount {

  @NonNull
  @Min(0)
  @JsonProperty("allocating_count")
  private Long allocatingCount;

  @NonNull
  @Min(0)
  @JsonProperty("creating_count")
  private Long creatingCount;

  @NonNull
  @Min(0)
  @JsonProperty("running_count")
  private Long runningCount;

  @NonNull
  @Min(0)
  @JsonProperty("stopping_count")
  private Long stoppingCount;
}
