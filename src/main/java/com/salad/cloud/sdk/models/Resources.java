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

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Resources {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long cpu;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long memory;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gpu_classes")
  private List<String> gpuClasses;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("storage_amount")
  private Long storageAmount;
}
