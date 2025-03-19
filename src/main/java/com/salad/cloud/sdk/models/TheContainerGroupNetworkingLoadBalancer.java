package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The container group networking load balancer.
 */
@Getter
@AllArgsConstructor
public enum TheContainerGroupNetworkingLoadBalancer {
  ROUND_ROBIN("round_robin"),
  LEAST_NUMBER_OF_CONNECTIONS("least_number_of_connections");

  @JsonValue
  private final String value;

  @JsonCreator
  public static TheContainerGroupNetworkingLoadBalancer fromValue(String value) {
    return Arrays
      .stream(TheContainerGroupNetworkingLoadBalancer.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
