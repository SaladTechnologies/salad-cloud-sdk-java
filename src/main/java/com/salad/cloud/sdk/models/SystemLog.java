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
 * Represents a system log
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class SystemLog {

  /**
   * The name of the event
   */
  @NonNull
  @JsonProperty("event_name")
  private String eventName;

  /**
   * The UTC date & time when the log item was created
   */
  @NonNull
  @JsonProperty("event_time")
  private String eventTime;

  /**
   * The version instance ID
   */
  @NonNull
  private String version;

  /**
   * The number of CPUs
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("resource_cpu")
  private Long resourceCpu;

  /**
   * The memory amount in MB
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("resource_memory")
  private Long resourceMemory;

  /**
   * The GPU class name
   */
  @NonNull
  @JsonProperty("resource_gpu_class")
  private String resourceGpuClass;

  /**
   * The storage amount in bytes
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("resource_storage_amount")
  private Long resourceStorageAmount;

  /**
   * The unique instance ID
   */
  @JsonProperty("instance_id")
  private String instanceId;

  /**
   * The organization-specific machine ID
   */
  @JsonProperty("machine_id")
  private String machineId;

  // Overwrite lombok builder methods
  public static class SystemLogBuilder {

    /**
     * Flag to track if the resourceCpu property has been set.
     */
    private boolean resourceCpu$set = false;

    /**
     * Flag to track if the resourceMemory property has been set.
     */
    private boolean resourceMemory$set = false;

    /**
     * Flag to track if the resourceStorageAmount property has been set.
     */
    private boolean resourceStorageAmount$set = false;

    public SystemLogBuilder resourceCpu(Long resourceCpu) {
      this.resourceCpu$set = true;
      this.resourceCpu = resourceCpu;
      return this;
    }

    public SystemLogBuilder resourceMemory(Long resourceMemory) {
      this.resourceMemory$set = true;
      this.resourceMemory = resourceMemory;
      return this;
    }

    public SystemLogBuilder resourceStorageAmount(Long resourceStorageAmount) {
      this.resourceStorageAmount$set = true;
      this.resourceStorageAmount = resourceStorageAmount;
      return this;
    }

    public SystemLog build() {
      if (!resourceCpu$set) {
        throw new IllegalStateException("resourceCpu is required");
      }
      if (!resourceMemory$set) {
        throw new IllegalStateException("resourceMemory is required");
      }
      if (!resourceStorageAmount$set) {
        throw new IllegalStateException("resourceStorageAmount is required");
      }
      return new SystemLog(
        eventName,
        eventTime,
        version,
        resourceCpu,
        resourceMemory,
        resourceGpuClass,
        resourceStorageAmount,
        instanceId,
        machineId
      );
    }
  }
}
