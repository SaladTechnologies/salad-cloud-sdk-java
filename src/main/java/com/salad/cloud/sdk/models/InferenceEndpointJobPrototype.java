package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private Object metadata;

  /**
   * The webhook URL to which the job results will be POSTed.
   */
  private String webhook;

  /**
   * The webhook URL to which the job results will be POSTed.
   */
  @JsonProperty("webhook_url")
  private String webhookUrl;
}
