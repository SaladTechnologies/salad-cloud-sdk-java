package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

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
  @JsonProperty("client_request_timeout")
  private JsonNullable<Long> clientRequestTimeout;

  /**
   * The container group networking load balancer.
   */
  @JsonProperty("load_balancer")
  private JsonNullable<TheContainerGroupNetworkingLoadBalancer> loadBalancer;

  /**
   * The container group networking server response timeout.
   */
  @JsonProperty("server_response_timeout")
  private JsonNullable<Long> serverResponseTimeout;

  /**
   * The container group networking single connection limit flag.
   */
  @JsonProperty("single_connection_limit")
  private JsonNullable<Boolean> singleConnectionLimit;

  @JsonIgnore
  public Long getClientRequestTimeout() {
    return clientRequestTimeout.orElse(null);
  }

  @JsonIgnore
  public TheContainerGroupNetworkingLoadBalancer getLoadBalancer() {
    return loadBalancer.orElse(null);
  }

  @JsonIgnore
  public Long getServerResponseTimeout() {
    return serverResponseTimeout.orElse(null);
  }

  @JsonIgnore
  public Boolean getSingleConnectionLimit() {
    return singleConnectionLimit.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateContainerGroupNetworkingBuilder {

    private JsonNullable<Long> clientRequestTimeout = JsonNullable.of(100000L);

    @JsonProperty("client_request_timeout")
    public CreateContainerGroupNetworkingBuilder clientRequestTimeout(Long value) {
      if (value == null) {
        throw new IllegalStateException("clientRequestTimeout cannot be null");
      }
      this.clientRequestTimeout = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TheContainerGroupNetworkingLoadBalancer> loadBalancer = JsonNullable.undefined();

    @JsonProperty("load_balancer")
    public CreateContainerGroupNetworkingBuilder loadBalancer(TheContainerGroupNetworkingLoadBalancer value) {
      if (value == null) {
        throw new IllegalStateException("loadBalancer cannot be null");
      }
      this.loadBalancer = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> serverResponseTimeout = JsonNullable.of(100000L);

    @JsonProperty("server_response_timeout")
    public CreateContainerGroupNetworkingBuilder serverResponseTimeout(Long value) {
      if (value == null) {
        throw new IllegalStateException("serverResponseTimeout cannot be null");
      }
      this.serverResponseTimeout = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> singleConnectionLimit = JsonNullable.undefined();

    @JsonProperty("single_connection_limit")
    public CreateContainerGroupNetworkingBuilder singleConnectionLimit(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("singleConnectionLimit cannot be null");
      }
      this.singleConnectionLimit = JsonNullable.of(value);
      return this;
    }
  }
}
