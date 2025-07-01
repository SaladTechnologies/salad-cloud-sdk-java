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
 * Represents a inference endpoint job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJob {

  /**
   * The inference endpoint job identifier.
   */
  @NonNull
  private String id;

  /**
   * The inference endpoint name.
   */
  @NonNull
  @JsonProperty("inference_endpoint_name")
  private String inferenceEndpointName;

  /**
   * The organization name.
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * The current status.
   */
  @NonNull
  private Status status;

  /**
   * The list of events.
   */
  @NonNull
  private List<InferenceEndpointJobEvent> events;

  /**
   * The time the job was created.
   */
  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  /**
   * The time the job was last updated.
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The job metadata. May be any valid JSON.
   */
  @JsonProperty("metadata")
  private JsonNullable<Object> metadata;

  /**
   * The webhook URL called when the job completes.
   */
  @JsonProperty("webhook")
  private JsonNullable<String> webhook;

  /**
   * The webhook URL called when the job completes.
   */
  @JsonProperty("webhook_url")
  private JsonNullable<String> webhookUrl;

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
  public String getWebhookUrl() {
    return webhookUrl.orElse(null);
  }

  @JsonIgnore
  public Object getOutput() {
    return output.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class InferenceEndpointJobBuilder {

    private JsonNullable<Object> metadata = JsonNullable.undefined();

    @JsonProperty("metadata")
    public InferenceEndpointJobBuilder metadata(Object value) {
      if (value == null) {
        throw new IllegalStateException("metadata cannot be null");
      }
      this.metadata = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public InferenceEndpointJobBuilder webhook(String value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> webhookUrl = JsonNullable.undefined();

    @JsonProperty("webhook_url")
    public InferenceEndpointJobBuilder webhookUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("webhookUrl cannot be null");
      }
      this.webhookUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Object> output = JsonNullable.undefined();

    @JsonProperty("output")
    public InferenceEndpointJobBuilder output(Object value) {
      if (value == null) {
        throw new IllegalStateException("output cannot be null");
      }
      this.output = JsonNullable.of(value);
      return this;
    }
  }
}
