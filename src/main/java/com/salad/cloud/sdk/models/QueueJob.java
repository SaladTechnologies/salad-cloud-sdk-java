package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

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
  @JsonProperty("metadata")
  private JsonNullable<Object> metadata;

  /**
   * The webhook URL to notify when the job completes
   */
  @JsonProperty("webhook")
  private JsonNullable<String> webhook;

  /**
   * The job output. May be any valid JSON.
   */
  @JsonProperty("output")
  private JsonNullable<Object> output;

  @JsonIgnore
  public Object getMetadata() {
    return metadata.orElse(null);
  }

  @JsonIgnore
  public String getWebhook() {
    return webhook.orElse(null);
  }

  @JsonIgnore
  public Object getOutput() {
    return output.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QueueJobBuilder {

    private JsonNullable<Object> metadata = JsonNullable.undefined();

    @JsonProperty("metadata")
    public QueueJobBuilder metadata(Object value) {
      if (value == null) {
        throw new IllegalStateException("metadata cannot be null");
      }
      this.metadata = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public QueueJobBuilder webhook(String value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Object> output = JsonNullable.undefined();

    @JsonProperty("output")
    public QueueJobBuilder output(Object value) {
      if (value == null) {
        throw new IllegalStateException("output cannot be null");
      }
      this.output = JsonNullable.of(value);
      return this;
    }
  }
}
