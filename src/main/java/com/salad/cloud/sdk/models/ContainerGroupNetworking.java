package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents container group networking parameters
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupNetworking {

  @NonNull
  private ContainerNetworkingProtocol protocol;

  @NonNull
  private Long port;

  @NonNull
  private Boolean auth;

  @NonNull
  private String dns;

  @JsonProperty("load_balancer")
  private ContainerGroupNetworkingLoadBalancer loadBalancer;

  @JsonProperty("single_connection_limit")
  private Boolean singleConnectionLimit;

  @Builder.Default
  @JsonProperty("client_request_timeout")
  private Long clientRequestTimeout = 100000L;

  @Builder.Default
  @JsonProperty("server_response_timeout")
  private Long serverResponseTimeout = 100000L;
}
