package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The sort order of the log entries. `asc` will sort the log entries in chronological order. `desc` will sort the log entries in reverse chronological order.
 */
@Getter
@AllArgsConstructor
public enum LogEntryQuerySortOrder {
  DESC("desc"),
  ASC("asc");

  @JsonValue
  private final String value;

  @JsonCreator
  public static LogEntryQuerySortOrder fromValue(String value) {
    return Arrays.stream(LogEntryQuerySortOrder.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
