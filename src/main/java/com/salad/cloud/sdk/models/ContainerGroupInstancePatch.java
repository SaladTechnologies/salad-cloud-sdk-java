package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a request to update a container group instance
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstancePatch {

  /**
   * The cost of deleting the container group instance
   */
  @JsonProperty("deletion_cost")
  private JsonNullable<Long> deletionCost;

  @JsonIgnore
  public Long getDeletionCost() {
    return deletionCost.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupInstancePatchBuilder {

    private JsonNullable<Long> deletionCost = JsonNullable.undefined();

    @JsonProperty("deletion_cost")
    public ContainerGroupInstancePatchBuilder deletionCost(Long value) {
      this.deletionCost = JsonNullable.of(value);
      return this;
    }
  }
}
