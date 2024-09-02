package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The state of the container group instance
 */
@Getter
@AllArgsConstructor
public enum State {
  ALLOCATING("allocating"),
  DOWNLOADING("downloading"),
  CREATING("creating"),
  RUNNING("running"),
  STOPPING("stopping");

  @JsonValue
  private final String value;

  @JsonCreator
  public static State fromValue(String value) {
    return Arrays.stream(State.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
