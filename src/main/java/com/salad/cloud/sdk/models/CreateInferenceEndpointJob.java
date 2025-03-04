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
public class CreateInferenceEndpointJob {

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  private Object metadata;

  private String webhook;

  @JsonProperty("webhook_url")
  private String webhookUrl;
}
