package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("deletion_cost")
  private Long deletionCost;
}
