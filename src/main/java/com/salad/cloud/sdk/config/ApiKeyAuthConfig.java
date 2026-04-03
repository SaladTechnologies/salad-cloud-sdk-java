package com.salad.cloud.sdk.config;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * Configuration for API key authentication.
 * Stores the API key value and the header name where it should be sent.
 */
@Builder
@Data
public class ApiKeyAuthConfig {

  @NonNull
  @Builder.Default
  private String apiKeyHeader = "Salad-Api-Key";

  private String apiKey;
}
