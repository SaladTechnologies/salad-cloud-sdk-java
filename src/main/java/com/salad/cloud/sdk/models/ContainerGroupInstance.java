package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A Container Group Instance represents a running instance of a container group on a specific machine. It provides information about the execution state, readiness, and version of the deployed container group.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstance {

  /**
   * The container group instance identifier.
   */
  @NonNull
  private String id;

  /**
   * The container group machine identifier.
   */
  @NonNull
  @JsonProperty("machine_id")
  private String machineId;

  /**
   * The state of the container group instance
   */
  @NonNull
  private TheContainerGroupInstanceState state;

  /**
   * The UTC timestamp when the container group instance last changed its state. This helps track the lifecycle and state transitions of the instance.
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The version of the container group definition currently running on this instance. Used to track deployment and update progress across the container group fleet.
   */
  @NonNull
  private Long version;

  /**
   * Indicates whether the container group instance is currently passing its readiness checks and is able to receive traffic or perform its intended function. If no readiness probe is defined, this will be true once the instance is fully started.
   */
  @JsonProperty("ready")
  private JsonNullable<Boolean> ready;

  /**
   * Indicates whether the container group instance has successfully completed its startup sequence and passed any configured startup probes. This will always be true when no startup probe is defined for the container group.
   */
  @JsonProperty("started")
  private JsonNullable<Boolean> started;

  /**
   * The cost of deleting the container group instance
   */
  @JsonProperty("deletion_cost")
  private JsonNullable<Long> deletionCost;

  @JsonIgnore
  public Boolean getReady() {
    return ready.orElse(null);
  }

  @JsonIgnore
  public Boolean getStarted() {
    return started.orElse(null);
  }

  @JsonIgnore
  public Long getDeletionCost() {
    return deletionCost.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupInstanceBuilder {

    private JsonNullable<Boolean> ready = JsonNullable.undefined();

    @JsonProperty("ready")
    public ContainerGroupInstanceBuilder ready(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("ready cannot be null");
      }
      this.ready = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> started = JsonNullable.undefined();

    @JsonProperty("started")
    public ContainerGroupInstanceBuilder started(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("started cannot be null");
      }
      this.started = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> deletionCost = JsonNullable.undefined();

    @JsonProperty("deletion_cost")
    public ContainerGroupInstanceBuilder deletionCost(Long value) {
      if (value == null) {
        throw new IllegalStateException("deletionCost cannot be null");
      }
      this.deletionCost = JsonNullable.of(value);
      return this;
    }
  }
}
