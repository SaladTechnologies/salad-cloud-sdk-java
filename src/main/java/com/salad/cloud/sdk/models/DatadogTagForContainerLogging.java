package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a Datadog tag used for container logging metadata.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DatadogTagForContainerLogging {

  /**
   * The name of the metadata tag.
   */
  @NonNull
  private String name;

  /**
   * The value of the metadata tag.
   */
  @NonNull
  private String value;
}
