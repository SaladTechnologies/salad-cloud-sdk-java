package com.salad.cloud.sdk.models;

import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * The resource associated with the log entry
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LogEntryResource {

  /**
   * The labels associated with the resource
   */
  @NonNull
  private Map<String, String> labels;

  /**
   * The type of the resource
   */
  @NonNull
  private String type;
}
