package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the price of a GPU class for a given container group priority
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class GpuClassPrice {

  /**
   * The price
   */
  @NonNull
  private String price;

  /**
   * Specifies the priority level for container group execution, which determines resource allocation and scheduling precedence.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  // Overwrite lombok builder methods
  public static class GpuClassPriceBuilder {

    /**
     * Flag to track if the priority property has been set.
     */
    private boolean priority$set = false;

    public GpuClassPriceBuilder priority(ContainerGroupPriority priority) {
      this.priority$set = true;
      this.priority = priority;
      return this;
    }

    public GpuClassPrice build() {
      if (!priority$set) {
        throw new IllegalStateException("priority is required");
      }
      return new GpuClassPrice(price, priority);
    }
  }
}
