package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The severity level of the log entry
 */
@Getter
@AllArgsConstructor
public enum LogEntrySeverity {
  DEBUG("debug"),
  INFO("info"),
  NOTICE("notice"),
  WARNING("warning"),
  ERROR("error"),
  CRITICAL("critical"),
  ALERT("alert"),
  EMERGENCY("emergency");

  @JsonValue
  private final String value;

  @JsonCreator
  public static LogEntrySeverity fromValue(String value) {
    return Arrays.stream(LogEntrySeverity.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
