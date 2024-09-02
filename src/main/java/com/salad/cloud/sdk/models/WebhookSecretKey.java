package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a webhook secret key
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class WebhookSecretKey {

  /**
   * The webhook secret key
   */
  @NonNull
  @JsonProperty("secret_key")
  private String secretKey;
}
