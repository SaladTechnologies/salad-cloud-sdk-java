package com.salad.cloud.sdk.config;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class ApiKeyAuthConfig {

  @NonNull
  @Builder.Default
  private String apiKeyHeader = "Salad-Api-Key";

  private String apiKey;
}
