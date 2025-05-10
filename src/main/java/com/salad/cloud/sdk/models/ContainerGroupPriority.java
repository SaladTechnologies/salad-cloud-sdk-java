package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Specifies the priority level for container group execution, which determines resource allocation and scheduling precedence.
 */
@Getter
@AllArgsConstructor
public enum ContainerGroupPriority {
  HIGH("high"),
  MEDIUM("medium"),
  LOW("low"),
  BATCH("batch");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ContainerGroupPriority fromValue(String value) {
    return Arrays.stream(ContainerGroupPriority.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
