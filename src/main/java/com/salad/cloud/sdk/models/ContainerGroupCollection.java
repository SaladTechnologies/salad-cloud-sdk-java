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
 * A paginated collection of container groups that provides a structured way to access multiple container group resources in a single response.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupCollection {

  /**
   * An array containing container group objects. Each object represents a discrete container group with its own properties, configuration, and status.
   */
  @NonNull
  private List<ContainerGroup> items;
}
