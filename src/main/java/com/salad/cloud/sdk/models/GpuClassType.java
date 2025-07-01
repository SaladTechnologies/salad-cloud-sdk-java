package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type of GPU class
 */
@Getter
@AllArgsConstructor
public enum GpuClassType {
  COMMUNITY("community"),
  SECURE("secure");

  @JsonValue
  private final String value;

  @JsonCreator
  public static GpuClassType fromValue(String value) {
    return Arrays.stream(GpuClassType.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
