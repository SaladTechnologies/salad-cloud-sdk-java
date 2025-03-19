package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  /**
   * The amount of storage (in bytes) required by the container. Must be between 1 GB (1073741824 bytes) and 50 GB (53687091200 bytes).
   */
  @JsonProperty("storage_amount")
  private Long storageAmount;

  // Overwrite lombok builder methods
  public static class ContainerResourceRequirementsBuilder {

    /**
     * Flag to track if the gpuClasses property has been set.
     */
    private boolean gpuClasses$set = false;

    public ContainerResourceRequirementsBuilder gpuClasses(List<String> gpuClasses) {
      this.gpuClasses$set = true;
      this.gpuClasses = gpuClasses;
      return this;
    }

    public ContainerResourceRequirements build() {
      if (!gpuClasses$set) {
        throw new IllegalStateException("gpuClasses is required");
      }
      return new ContainerResourceRequirements(cpu, memory, gpuClasses, storageAmount);
    }
  }
}
