package com.salad.cloud.sdk.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * A collection of container group instances returned as part of a paginated response or batch operation result.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstanceCollection {

  /**
   * An array of container group instances, each representing a deployed container group with its current state and configuration information.
   */
  @NonNull
  private List<ContainerGroupInstance> instances;
}
