package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Configuration for forwarding container logs to a remote TCP endpoint
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class TcpLoggingConfiguration {

  /**
   * The hostname or IP address of the remote TCP logging endpoint
   */
  @NonNull
  private String host;

  /**
   * The port number on which the TCP logging endpoint is listening
   */
  @NonNull
  private Long port;
}
