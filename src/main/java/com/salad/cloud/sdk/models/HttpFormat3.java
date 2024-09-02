package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFormat3 {
  JSON("json"),
  JSON_LINES("json_lines");

  @JsonValue
  private final String value;

  @JsonCreator
  public static HttpFormat3 fromValue(String value) {
    return Arrays.stream(HttpFormat3.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}