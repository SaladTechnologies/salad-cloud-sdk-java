package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Defines the communication protocol used for network traffic between containers or external systems. Currently supports HTTP protocol for web-based communication.
 */
@Getter
@AllArgsConstructor
public enum ContainerNetworkingProtocol {
  HTTP("http");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerNetworkingProtocol fromValue(String value) {
    return Arrays.stream(ContainerNetworkingProtocol.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
