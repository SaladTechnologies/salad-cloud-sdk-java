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
 * Represents a queue job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueJob {

  /**
   * The job identifier
   */
  @NonNull
  private String id;

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * The job status
   */
  @NonNull
  private QueueJobStatus status;

  /**
   * The job events
   */
  @NonNull
  private List<QueueJobEvent> events;

  /**
   * The job creation time
   */
  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  /**
   * The job update time
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * Additional metadata for the job
   */
  private Object metadata;

  /**
   * The webhook URL to notify when the job completes
   */
  private String webhook;

  /**
   * The job output. May be any valid JSON.
   */
  private Object output;
}
