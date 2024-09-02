package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpCompression3 {
  NONE("none"),
  GZIP("gzip");

  @JsonValue
  private final String value;

  @JsonCreator
  public static HttpCompression3 fromValue(String value) {
    return Arrays.stream(HttpCompression3.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
