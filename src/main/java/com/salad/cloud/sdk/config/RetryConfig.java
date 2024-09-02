package com.salad.cloud.sdk.config;

import com.salad.cloud.sdk.http.HttpMethod;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetryConfig {

  @Builder.Default
  private int maxRetries = 3;

  @Builder.Default
  private int initialDelay = 150;

  @Builder.Default
  private int maxDelay = 5000;

  @Builder.Default
  private double backoffFactor = 2;

  @Builder.Default
  private int jitter = 50;

  @Builder.Default
  private List<Integer> statusCodesToRetry = Arrays.asList(408, 429, 500, 502, 503, 504);

  @Builder.Default
  private List<HttpMethod> httpMethodsToRetry = Arrays.asList(
    HttpMethod.GET,
    HttpMethod.POST,
    HttpMethod.PUT,
    HttpMethod.DELETE,
    HttpMethod.PATCH,
    HttpMethod.HEAD,
    HttpMethod.OPTIONS
  );

  @Builder.Default
  private List<Class<? extends Throwable>> exceptionsToRetry = Arrays.asList(
    SocketException.class,
    SocketTimeoutException.class,
    ProtocolException.class
  );
}
