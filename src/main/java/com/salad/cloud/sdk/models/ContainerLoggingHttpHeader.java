package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an HTTP header used for container logging configuration.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerLoggingHttpHeader {

  /**
   * The name of the HTTP header
   */
  @NonNull
  private String name;

  /**
   * The value of the HTTP header
   */
  @NonNull
  private String value;
}
