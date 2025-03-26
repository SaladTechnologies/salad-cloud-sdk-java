package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The format in which logs will be delivered
 */
@Getter
@AllArgsConstructor
public enum ContainerHttpLoggingConfigurationFormat2 {
  JSON("json"),
  JSON_LINES("json_lines");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerHttpLoggingConfigurationFormat2 fromValue(String value) {
    return Arrays
      .stream(ContainerHttpLoggingConfigurationFormat2.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
