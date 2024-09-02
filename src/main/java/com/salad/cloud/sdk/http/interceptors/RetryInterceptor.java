package com.salad.cloud.sdk.http.interceptors;

import com.salad.cloud.sdk.config.RetryConfig;
import com.salad.cloud.sdk.http.HttpMethod;
import java.io.IOException;
import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@AllArgsConstructor
public class RetryInterceptor implements Interceptor {

  private RetryConfig config;

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    int tryCount = 0;

    Response response = null;
    while (tryCount <= config.getMaxRetries()) {
      if (response != null) {
        response.close();
      }

      try {
        response = chain.proceed(request);
        if (!isRetryable(response)) {
          return response;
        }
        tryCount++;
      } catch (IOException e) {
        if (!config.getExceptionsToRetry().contains(e.getClass()) || tryCount == config.getMaxRetries()) {
          throw e;
        }
      }

      final int delay = calculateDelay(tryCount);
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Thread interrupted while waiting for retry", e);
      }
    }

    return response;
  }

  private int calculateDelay(int tryCount) {
    final int delay = (int) (config.getInitialDelay() * Math.pow(config.getBackoffFactor(), tryCount - 1));
    return Math.min(delay, config.getMaxDelay());
  }

  private boolean isRetryable(Response response) {
    final boolean isRetryableStatusCode = config.getStatusCodesToRetry().contains(response.code());
    final boolean isRetryableMethod = config
      .getHttpMethodsToRetry()
      .stream()
      .map((HttpMethod m) -> m.getMethod())
      .anyMatch(method -> method.equals(response.request().method()));

    return isRetryableStatusCode && isRetryableMethod;
  }
}
