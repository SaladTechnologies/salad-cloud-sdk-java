package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents container group networking parameters
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerGroupNetworking {

  @NonNull
  private ContainerNetworkingProtocol protocol;

  @NonNull
  private Long port;

  @NonNull
  private Boolean auth;
}
