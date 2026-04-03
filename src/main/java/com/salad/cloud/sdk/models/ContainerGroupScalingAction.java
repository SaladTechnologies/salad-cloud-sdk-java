package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a scaling action configuration for a container group
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupScalingAction {

  /**
   * The number of replicas to scale to during the scheduled period
   */
  @NonNull
  private Long replicas;

  /**
   * The cron-style schedule string defining when the scaling should occur
   */
  @NonNull
  private String schedule;
}
