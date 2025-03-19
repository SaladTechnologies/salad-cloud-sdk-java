package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The protocol scheme used for HTTP probe requests in container health checks.
 */
@Getter
@AllArgsConstructor
public enum HttpScheme {
  HTTP("http"),
  HTTPS("https");

  @JsonValue
  private final String value;

  @JsonCreator
  public static HttpScheme fromValue(String value) {
    return Arrays.stream(HttpScheme.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
