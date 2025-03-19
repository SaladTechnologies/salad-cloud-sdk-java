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
 * Configuration settings for integrating container logs with the Axiom logging service. When specified, container logs will be forwarded to the Axiom instance defined by these parameters.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AxiomLoggingConfiguration {

  /**
   * The Axiom host URL where logs will be sent (e.g. logs.axiom.co)
   */
  @NonNull
  private String host;

  /**
   * Authentication token for the Axiom API with appropriate write permissions
   */
  @NonNull
  @JsonProperty("api_token")
  private String apiToken;

  /**
   * Name of the Axiom dataset where the container logs will be stored and indexed
   */
  @NonNull
  private String dataset;
}
