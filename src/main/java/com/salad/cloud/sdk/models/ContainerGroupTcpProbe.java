package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Configuration for a TCP probe used to check container health via network connectivity.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupTcpProbe {

  /**
   * The TCP port number that the probe should connect to. Must be a valid port number between 0 and 65535.
   */
  @NonNull
  private Long port;
}
