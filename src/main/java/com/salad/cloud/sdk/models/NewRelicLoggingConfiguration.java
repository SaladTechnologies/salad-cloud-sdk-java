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
 * Configuration for sending container logs to New Relic's log management platform.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class NewRelicLoggingConfiguration {

  /**
   * The New Relic endpoint host for log ingestion (e.g., log-api.newrelic.com).
   */
  @NonNull
  private String host;

  /**
   * The New Relic license or ingestion key used for authentication and data routing.
   */
  @NonNull
  @JsonProperty("ingestion_key")
  private String ingestionKey;
}
