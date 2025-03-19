package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupProbeHttpHeader {

  /**
   * The name of the HTTP header
   */
  @NonNull
  private String name;

  /**
   * The value associated with the HTTP header
   */
  @NonNull
  private String value;
}
