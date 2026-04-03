package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Specifies the resource requirements for creating a container.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerResourceRequirements {

  /**
   * The number of CPU cores to allocate to the container (between 1 and 1024).
   */
  @NonNull
  private Long cpu;

  /**
   * The amount of memory to allocate to the container in megabytes (between 1024 and 1073741824).
   */
  @NonNull
  private Long memory;

  /**
   * A list of GPU class UUIDs required by the container. Can be null if no GPU is required.
   */
  @JsonProperty("gpu_classes")
  private JsonNullable<List<String>> gpuClasses;

  /**
   * The amount of shared memory to allocate to the container via `/dev/shm` in megabytes (between 64 and 1073741824). If not specified, defaults to 64 MB.
   */
  @JsonProperty("shm_size")
  private JsonNullable<Long> shmSize;

  /**
   * The amount of storage to allocate to the container in bytes (between 1 GB and 1 PB).
   */
  @JsonProperty("storage_amount")
  private JsonNullable<Long> storageAmount;

  @JsonIgnore
  public List<String> getGpuClasses() {
    return gpuClasses.orElse(null);
  }

  @JsonIgnore
  public Long getShmSize() {
    return shmSize.orElse(null);
  }

  @JsonIgnore
  public Long getStorageAmount() {
    return storageAmount.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateContainerResourceRequirementsBuilder {

    private JsonNullable<List<String>> gpuClasses = JsonNullable.undefined();

    @JsonProperty("gpu_classes")
    public CreateContainerResourceRequirementsBuilder gpuClasses(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("gpuClasses cannot be null");
      }
      this.gpuClasses = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> shmSize = JsonNullable.of(64L);

    @JsonProperty("shm_size")
    public CreateContainerResourceRequirementsBuilder shmSize(Long value) {
      if (value == null) {
        throw new IllegalStateException("shmSize cannot be null");
      }
      this.shmSize = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> storageAmount = JsonNullable.undefined();

    @JsonProperty("storage_amount")
    public CreateContainerResourceRequirementsBuilder storageAmount(Long value) {
      if (value == null) {
        throw new IllegalStateException("storageAmount cannot be null");
      }
      this.storageAmount = JsonNullable.of(value);
      return this;
    }
  }
}
