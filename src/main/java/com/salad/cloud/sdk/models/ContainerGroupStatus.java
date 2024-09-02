package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContainerGroupStatus {
  PENDING("pending"),
  RUNNING("running"),
  STOPPED("stopped"),
  SUCCEEDED("succeeded"),
  FAILED("failed"),
  DEPLOYING("deploying");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerGroupStatus fromValue(String value) {
    return Arrays
      .stream(ContainerGroupStatus.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
