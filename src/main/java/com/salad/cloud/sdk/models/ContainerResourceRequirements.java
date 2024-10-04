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
 * Represents a container resource requirements
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerResourceRequirements {

  @NonNull
  private Long cpu;

  @NonNull
  private Long memory;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("storage_amount")
  private Long storageAmount;
}
