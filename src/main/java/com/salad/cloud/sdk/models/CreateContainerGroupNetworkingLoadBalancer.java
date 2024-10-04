package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CreateContainerGroupNetworkingLoadBalancer {
  ROUND_ROBIN("round_robin"),
  LEAST_NUMBER_OF_CONNECTIONS("least_number_of_connections");

  @JsonValue
  private final String value;

  @JsonCreator
  public static CreateContainerGroupNetworkingLoadBalancer fromValue(String value) {
    return Arrays
      .stream(CreateContainerGroupNetworkingLoadBalancer.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}