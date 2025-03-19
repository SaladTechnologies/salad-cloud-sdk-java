package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long cpu;

  /**
   * The amount of memory to allocate to the container in megabytes (between 1024MB and 61440MB).
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long memory;

  /**
   * List of GPU class identifiers that the container can use, specified as UUIDs.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  /**
   * The amount of storage to allocate to the container in bytes (between 1GB and 50GB).
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("storage_amount")
  private Long storageAmount;
}
