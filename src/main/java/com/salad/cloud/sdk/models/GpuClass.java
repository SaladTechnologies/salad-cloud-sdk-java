package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a GPU Class
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class GpuClass {

  /**
   * The unique identifier
   */
  @NonNull
  private String id;

  /**
   * The GPU class name
   */
  @NonNull
  @Length(min = 2, max = 63)
  private String name;

  /**
   * The list of prices for each container group priority
   */
  @NonNull
  private List<GpuClassPrice> prices;

  /**
   * Whether the GPU class is in high demand
   */
  @JsonProperty("is_high_demand")
  private Boolean isHighDemand;
}
