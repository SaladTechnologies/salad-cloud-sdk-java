package com.salad.cloud.sdk.models;

import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
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
  @Max(65535)
  @Min(1)
  private Long port;

  @NonNull
  private Boolean auth;
}
