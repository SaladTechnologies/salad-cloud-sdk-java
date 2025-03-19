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
 * Represents a workload error
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class WorkloadError {

  /**
   * The timestamp when the workload was initially allocated to a machine
   */
  @NonNull
  @JsonProperty("allocated_at")
  private String allocatedAt;

  /**
   * A detailed error message describing the nature and cause of the workload failure
   */
  @NonNull
  private String detail;

  /**
   * The timestamp when the workload failure was detected or reported
   */
  @NonNull
  @JsonProperty("failed_at")
  private String failedAt;

  /**
   * The container group instance identifier.
   */
  @NonNull
  @JsonProperty("instance_id")
  private String instanceId;

  /**
   * The container group machine identifier.
   */
  @NonNull
  @JsonProperty("machine_id")
  private String machineId;

  /**
   * The schema version number for this error record, used for tracking error format changes
   */
  @NonNull
  private Long version;

  /**
   * The timestamp when the workload started execution, or null if it failed before starting
   */
  @JsonProperty("started_at")
  private String startedAt;
}
