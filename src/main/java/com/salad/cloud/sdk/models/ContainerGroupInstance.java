package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the details of a single container group instance
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstance {

  /**
   * The unique instance ID
   */
  @NonNull
  @JsonProperty("instance_id")
  private String instanceId;

  /**
   * The machine ID
   */
  @NonNull
  @JsonProperty("machine_id")
  private String machineId;

  /**
   * The state of the container group instance
   */
  @NonNull
  private State state;

  /**
   * The UTC date & time when the workload on this machine transitioned to the current state
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The version of the running container group
   */
  @NonNull
  private Long version;

  /**
   * Specifies whether the container group instance is currently passing its readiness check. If no readiness probe is defined, is true once fully started.
   */
  private Boolean ready;

  /**
   * Specifies whether the container group instance passed its startup probe. Is always true when no startup probe is defined.
   */
  private Boolean started;
}
