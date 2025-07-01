package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a page of organization logs
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LogEntryCollection {

  /**
   * A collection of log entries
   */
  @NonNull
  private List<LogEntry> items;

  /**
   * The organization name.
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  /**
   * The maximum time page boundary. This may be used when getting paginated results.
   */
  @NonNull
  @JsonProperty("page_max_time")
  private String pageMaxTime;

  /**
   * The minimum time page boundary. This may be used when getting paginated results.
   */
  @NonNull
  @JsonProperty("page_min_time")
  private String pageMinTime;
}
