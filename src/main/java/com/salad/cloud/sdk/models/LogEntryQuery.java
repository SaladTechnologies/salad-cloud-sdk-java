package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a query for logs
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LogEntryQuery {

  /**
   * The end time of the time range
   */
  @NonNull
  @JsonProperty("end_time")
  private String endTime;

  /**
   * The query string for filtering logs
   */
  @NonNull
  private String query;

  /**
   * The start time of the time range
   */
  @NonNull
  @JsonProperty("start_time")
  private String startTime;

  /**
   * The maximum number of items per page.
   */
  @JsonProperty("page_size")
  private JsonNullable<Long> pageSize;

  /**
   * The sort order of the log entries. `asc` will sort the log entries in chronological order. `desc` will sort the log entries in reverse chronological order.
   */
  @JsonProperty("sort_order")
  private JsonNullable<LogEntryQuerySortOrder> sortOrder;

  @JsonIgnore
  public Long getPageSize() {
    return pageSize.orElse(null);
  }

  @JsonIgnore
  public LogEntryQuerySortOrder getSortOrder() {
    return sortOrder.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class LogEntryQueryBuilder {

    private JsonNullable<Long> pageSize = JsonNullable.undefined();

    @JsonProperty("page_size")
    public LogEntryQueryBuilder pageSize(Long value) {
      if (value == null) {
        throw new IllegalStateException("pageSize cannot be null");
      }
      this.pageSize = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<LogEntryQuerySortOrder> sortOrder = JsonNullable.undefined();

    @JsonProperty("sort_order")
    public LogEntryQueryBuilder sortOrder(LogEntryQuerySortOrder value) {
      if (value == null) {
        throw new IllegalStateException("sortOrder cannot be null");
      }
      this.sortOrder = JsonNullable.of(value);
      return this;
    }
  }
}
