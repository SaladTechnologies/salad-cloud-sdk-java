package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContainerNetworkingProtocol {
  HTTP("http");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerNetworkingProtocol fromValue(String value) {
    return Arrays
      .stream(ContainerNetworkingProtocol.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}