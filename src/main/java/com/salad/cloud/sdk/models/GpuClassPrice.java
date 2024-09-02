package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salad.cloud.sdk.validation.annotation.Length;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the price of a GPU class for a given container group priority
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class GpuClassPrice {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  /**
   * The price
   */
  @NonNull
  @Length(min = 1, max = 20)
  private String price;

  // Overwrite lombok builder methods
  public static class GpuClassPriceBuilder {

    /**
     * Flag to track if the priority property has been set.
     */
    private boolean wasPrioritySet = false;

    public GpuClassPriceBuilder priority(ContainerGroupPriority priority) {
      this.wasPrioritySet = true;
      this.priority = priority;
      return this;
    }

    public GpuClassPrice build() {
      if (!wasPrioritySet) {
        throw new IllegalStateException("priority is required");
      }
      return new GpuClassPrice(priority, price);
    }
  }
}
