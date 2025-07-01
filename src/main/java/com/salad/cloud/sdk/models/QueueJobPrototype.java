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
 * Represents a request to create a queue job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueJobPrototype {

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * Additional metadata for the job
   */
  @JsonProperty("metadata")
  private JsonNullable<Object> metadata;

  /**
   * The webhook to call when the job completes
   */
  @JsonProperty("webhook")
  private JsonNullable<String> webhook;

  @JsonIgnore
  public Object getMetadata() {
    return metadata.orElse(null);
  }

  @JsonIgnore
  public String getWebhook() {
    return webhook.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QueueJobPrototypeBuilder {

    private JsonNullable<Object> metadata = JsonNullable.undefined();

    @JsonProperty("metadata")
    public QueueJobPrototypeBuilder metadata(Object value) {
      if (value == null) {
        throw new IllegalStateException("metadata cannot be null");
      }
      this.metadata = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public QueueJobPrototypeBuilder webhook(String value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }
  }
}
