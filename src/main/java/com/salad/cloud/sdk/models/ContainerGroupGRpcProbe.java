package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Configuration for gRPC-based health probes in container groups, used to determine container health status.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupGRpcProbe {

  /**
   * The port number on which the gRPC health check service is exposed.
   */
  @NonNull
  private Long port;

  /**
   * The name of the gRPC service that implements the health check protocol.
   */
  @NonNull
  private String service;
}
