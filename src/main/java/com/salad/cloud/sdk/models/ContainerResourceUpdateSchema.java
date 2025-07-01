package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Defines the resource specifications that can be modified for a container group, including CPU, memory, GPU classes, and storage allocations.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerResourceUpdateSchema {

  /**
   * The number of CPU cores to allocate to the container (between 1 and 16 cores).
   */
  @JsonProperty("cpu")
  private JsonNullable<Long> cpu;

  /**
   * The amount of memory to allocate to the container in megabytes (between 1024MB and 61440MB).
   */
  @JsonProperty("memory")
  private JsonNullable<Long> memory;

  /**
   * List of GPU class identifiers that the container can use, specified as UUIDs.
   */
  @JsonProperty("gpu_classes")
  private JsonNullable<List<String>> gpuClasses;

  /**
   * The amount of storage to allocate to the container in bytes (between 1GB and 250GB).
   */
  @JsonProperty("storage_amount")
  private JsonNullable<Long> storageAmount;

  /**
   * The size of the shared memory (/dev/shm) in MB. If not specified, defaults to 64MB.
   */
  @JsonProperty("shm_size")
  private JsonNullable<Long> shmSize;

  @JsonIgnore
  public Long getCpu() {
    return cpu.orElse(null);
  }

  @JsonIgnore
  public Long getMemory() {
    return memory.orElse(null);
  }

  @JsonIgnore
  public List<String> getGpuClasses() {
    return gpuClasses.orElse(null);
  }

  @JsonIgnore
  public Long getStorageAmount() {
    return storageAmount.orElse(null);
  }

  @JsonIgnore
  public Long getShmSize() {
    return shmSize.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerResourceUpdateSchemaBuilder {

    private JsonNullable<Long> cpu = JsonNullable.undefined();

    @JsonProperty("cpu")
    public ContainerResourceUpdateSchemaBuilder cpu(Long value) {
      this.cpu = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> memory = JsonNullable.undefined();

    @JsonProperty("memory")
    public ContainerResourceUpdateSchemaBuilder memory(Long value) {
      this.memory = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> gpuClasses = JsonNullable.undefined();

    @JsonProperty("gpu_classes")
    public ContainerResourceUpdateSchemaBuilder gpuClasses(List<String> value) {
      this.gpuClasses = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> storageAmount = JsonNullable.undefined();

    @JsonProperty("storage_amount")
    public ContainerResourceUpdateSchemaBuilder storageAmount(Long value) {
      this.storageAmount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> shmSize = JsonNullable.of(64L);

    @JsonProperty("shm_size")
    public ContainerResourceUpdateSchemaBuilder shmSize(Long value) {
      this.shmSize = JsonNullable.of(value);
      return this;
    }
  }
}
