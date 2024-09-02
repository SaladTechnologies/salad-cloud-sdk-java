package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContainerRestartPolicy {
  ALWAYS("always"),
  ON_FAILURE("on_failure"),
  NEVER("never");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerRestartPolicy fromValue(String value) {
    return Arrays
      .stream(ContainerRestartPolicy.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
