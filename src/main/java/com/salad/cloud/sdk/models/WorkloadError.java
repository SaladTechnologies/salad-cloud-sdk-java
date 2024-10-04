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
 * Represents a workload error
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class WorkloadError {

  @NonNull
  private String detail;

  @NonNull
  @JsonProperty("failed_at")
  private String failedAt;

  @NonNull
  @JsonProperty("instance_id")
  private String instanceId;

  @NonNull
  @JsonProperty("machine_id")
  private String machineId;

  @NonNull
  @JsonProperty("allocated_at")
  private String allocatedAt;

  @NonNull
  private Long version;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("started_at")
  private String startedAt;
}
