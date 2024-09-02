package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a queue job
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueJob {

  @NonNull
  private String id;

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  @NonNull
  private QueueJobStatus status;

  @NonNull
  private List<QueueJobEvent> events;

  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object metadata;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String webhook;

  /**
   * The job output. May be any valid JSON.
   */
  private Object output;
}
