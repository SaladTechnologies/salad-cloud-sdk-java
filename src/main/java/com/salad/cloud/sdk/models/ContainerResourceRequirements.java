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
 * Specifies the resource requirements for a container.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerResourceRequirements {

  /**
   * The number of CPU cores required by the container. Must be between 1 and 16.
   */
  @NonNull
  private Long cpu;

  /**
   * The amount of memory (in MB) required by the container. Must be between 1024 MB and 61440 MB.
   */
  @NonNull
  private Long memory;

  /**
   * A list of GPU class UUIDs required by the container. Can be null if no GPU is required.
   */
  @NonNull
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  /**
   * The amount of storage (in bytes) required by the container. Must be between 1 GB (1073741824 bytes) and 250 GB (268435456000 bytes).
   */
  @JsonProperty("storage_amount")
  private JsonNullable<Long> storageAmount;

  /**
   * The size of the shared memory (/dev/shm) in MB. If not specified, defaults to 64MB.
   */
  @JsonProperty("shm_size")
  private JsonNullable<Long> shmSize;

  @JsonIgnore
  public Long getStorageAmount() {
    return storageAmount.orElse(null);
  }

  @JsonIgnore
  public Long getShmSize() {
    return shmSize.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerResourceRequirementsBuilder {

    private JsonNullable<Long> storageAmount = JsonNullable.undefined();

    @JsonProperty("storage_amount")
    public ContainerResourceRequirementsBuilder storageAmount(Long value) {
      if (value == null) {
        throw new IllegalStateException("storageAmount cannot be null");
      }
      this.storageAmount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> shmSize = JsonNullable.of(64L);

    @JsonProperty("shm_size")
    public ContainerResourceRequirementsBuilder shmSize(Long value) {
      if (value == null) {
        throw new IllegalStateException("shmSize cannot be null");
      }
      this.shmSize = JsonNullable.of(value);
      return this;
    }
  }
}
