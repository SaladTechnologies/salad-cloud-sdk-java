package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The current status.
 */
@Getter
@AllArgsConstructor
public enum Status {
  PENDING("pending"),
  RUNNING("running"),
  SUCCEEDED("succeeded"),
  CANCELLED("cancelled"),
  FAILED("failed");

  @JsonValue
  private final String value;

  @JsonCreator
  public static Status fromValue(String value) {
    return Arrays.stream(Status.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
