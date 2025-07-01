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
 * Represents a request to create a inference endpoint job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJobPrototype {

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * The job metadata. May be any valid JSON.
   */
  @JsonProperty("metadata")
  private JsonNullable<Object> metadata;

  /**
   * The webhook URL to which the job results will be POSTed.
   */
  @JsonProperty("webhook")
  private JsonNullable<String> webhook;

  /**
   * The webhook URL to which the job results will be POSTed.
   */
  @JsonProperty("webhook_url")
  private JsonNullable<String> webhookUrl;

  @JsonIgnore
  public Object getMetadata() {
    return metadata.orElse(null);
  }

  @JsonIgnore
  public String getWebhook() {
    return webhook.orElse(null);
  }

  @JsonIgnore
  public String getWebhookUrl() {
    return webhookUrl.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class InferenceEndpointJobPrototypeBuilder {

    private JsonNullable<Object> metadata = JsonNullable.undefined();

    @JsonProperty("metadata")
    public InferenceEndpointJobPrototypeBuilder metadata(Object value) {
      if (value == null) {
        throw new IllegalStateException("metadata cannot be null");
      }
      this.metadata = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public InferenceEndpointJobPrototypeBuilder webhook(String value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhookUrl = JsonNullable.undefined();

    @JsonProperty("webhook_url")
    public InferenceEndpointJobPrototypeBuilder webhookUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("webhookUrl cannot be null");
      }
      this.webhookUrl = JsonNullable.of(value);
      return this;
    }
  }
}
