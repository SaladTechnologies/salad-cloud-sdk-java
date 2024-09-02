package com.salad.cloud.sdk.config;

import com.salad.cloud.sdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class SaladCloudSdkConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "sdk/1.0.0";

  @NonNull
  @Builder.Default
  private Environment environment = Environment.DEFAULT;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  @NonNull
  @Builder.Default
  private ApiKeyAuthConfig apiKeyAuthConfig = ApiKeyAuthConfig.builder().build();

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;
}
