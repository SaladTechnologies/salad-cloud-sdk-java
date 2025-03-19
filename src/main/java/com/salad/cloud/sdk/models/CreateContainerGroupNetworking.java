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
 * Network configuration for container groups specifying connectivity parameters, including authentication, protocol, and timeout settings
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerGroupNetworking {

  /**
   * Determines whether authentication is required for network connections to the container group
   */
  @NonNull
  private Boolean auth;

  /**
   * The container group networking port.
   */
  @NonNull
  private Long port;

  /**
   * Defines the communication protocol used for network traffic between containers or external systems. Currently supports HTTP protocol for web-based communication.
   */
  @NonNull
  private ContainerNetworkingProtocol protocol;

  /**
   * The container group networking client request timeout.
   */
  @Builder.Default
  @JsonProperty("client_request_timeout")
  private Long clientRequestTimeout = 100000L;

  /**
   * The container group networking load balancer.
   */
  @JsonProperty("load_balancer")
  private TheContainerGroupNetworkingLoadBalancer loadBalancer;

  /**
   * The container group networking server response timeout.
   */
  @Builder.Default
  @JsonProperty("server_response_timeout")
  private Long serverResponseTimeout = 100000L;

  /**
   * The container group networking single connection limit flag.
   */
  @JsonProperty("single_connection_limit")
  private Boolean singleConnectionLimit;
}
