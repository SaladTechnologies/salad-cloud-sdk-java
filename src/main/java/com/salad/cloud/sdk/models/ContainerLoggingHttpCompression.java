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
public enum ContainerLoggingHttpCompression {
  NONE("none"),
  GZIP("gzip");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerLoggingHttpCompression fromValue(String value) {
    return Arrays
      .stream(ContainerLoggingHttpCompression.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
