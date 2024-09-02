package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a container resource requirements
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerResourceRequirements {

  @NonNull
  @Max(16)
  @Min(1)
  private Long cpu;

  @NonNull
  @Max(30720)
  @Min(1024)
  private Long memory;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Max(53687091200)
  @Min(1073741824)
  @JsonProperty("storage_amount")
  private Long storageAmount;
}
