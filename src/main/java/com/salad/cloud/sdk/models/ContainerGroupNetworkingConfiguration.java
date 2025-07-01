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
 * Network configuration for container groups that defines connectivity, routing, and access control settings
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupNetworkingConfiguration {

  /**
   * Whether authentication is required for network access to the container group
   */
  @NonNull
  private Boolean auth;

  /**
   * Domain name or URL endpoint for the container group's network interface
   */
  @NonNull
  private String dns;

  /**
   * The container group networking load balancer.
   */
  @NonNull
  @JsonProperty("load_balancer")
  private TheContainerGroupNetworkingLoadBalancer loadBalancer;

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
  public Long getServerResponseTimeout() {
    return serverResponseTimeout.orElse(null);
  }

  @JsonIgnore
  public Boolean getSingleConnectionLimit() {
    return singleConnectionLimit.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupNetworkingConfigurationBuilder {

    private JsonNullable<Long> clientRequestTimeout = JsonNullable.of(100000L);

    @JsonProperty("client_request_timeout")
    public ContainerGroupNetworkingConfigurationBuilder clientRequestTimeout(Long value) {
      if (value == null) {
        throw new IllegalStateException("clientRequestTimeout cannot be null");
      }
      this.clientRequestTimeout = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> serverResponseTimeout = JsonNullable.of(100000L);

    @JsonProperty("server_response_timeout")
    public ContainerGroupNetworkingConfigurationBuilder serverResponseTimeout(Long value) {
      if (value == null) {
        throw new IllegalStateException("serverResponseTimeout cannot be null");
      }
      this.serverResponseTimeout = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> singleConnectionLimit = JsonNullable.undefined();

    @JsonProperty("single_connection_limit")
    public ContainerGroupNetworkingConfigurationBuilder singleConnectionLimit(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("singleConnectionLimit cannot be null");
      }
      this.singleConnectionLimit = JsonNullable.of(value);
      return this;
    }
  }
}
