package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InferenceEndpointJobStatus {
  PENDING("pending"),
  RUNNING("running"),
  SUCCEEDED("succeeded"),
  CANCELLED("cancelled"),
  FAILED("failed");

  @JsonValue
  private final String value;

  @JsonCreator
  public static InferenceEndpointJobStatus fromValue(String value) {
    return Arrays
      .stream(InferenceEndpointJobStatus.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
