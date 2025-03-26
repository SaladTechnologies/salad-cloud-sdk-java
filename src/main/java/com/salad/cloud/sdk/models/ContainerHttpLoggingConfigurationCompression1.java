package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The compression algorithm to apply to logs before transmission
 */
@Getter
@AllArgsConstructor
public enum ContainerHttpLoggingConfigurationCompression1 {
  NONE("none"),
  GZIP("gzip");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerHttpLoggingConfigurationCompression1 fromValue(String value) {
    return Arrays
      .stream(ContainerHttpLoggingConfigurationCompression1.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
