package com.salad.cloud.sdk;

import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.interceptors.DefaultHeadersInterceptor;
import com.salad.cloud.sdk.http.interceptors.RetryInterceptor;
import com.salad.cloud.sdk.services.ContainerGroupsService;
import com.salad.cloud.sdk.services.InferenceEndpointsService;
import com.salad.cloud.sdk.services.OrganizationDataService;
import com.salad.cloud.sdk.services.QueuesService;
import com.salad.cloud.sdk.services.QuotasService;
import com.salad.cloud.sdk.services.SystemLogsService;
import com.salad.cloud.sdk.services.WebhookSecretKeyService;
import com.salad.cloud.sdk.services.WorkloadErrorsService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** The SaladCloud REST API. Please refer to the [SaladCloud API Documentation](https://docs.salad.com/api-reference) for more details. */
public class SaladCloudSdk {

  public final ContainerGroupsService containerGroups;
  public final WorkloadErrorsService workloadErrors;
  public final SystemLogsService systemLogs;
  public final QueuesService queues;
  public final QuotasService quotas;
  public final InferenceEndpointsService inferenceEndpoints;
  public final OrganizationDataService organizationData;
  public final WebhookSecretKeyService webhookSecretKey;

  private final SaladCloudSdkConfig config;

  public SaladCloudSdk() {
    // Default configs
    this(SaladCloudSdkConfig.builder().build());
  }

  public SaladCloudSdk(SaladCloudSdkConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.containerGroups = new ContainerGroupsService(httpClient, config);
    this.workloadErrors = new WorkloadErrorsService(httpClient, config);
    this.systemLogs = new SystemLogsService(httpClient, config);
    this.queues = new QueuesService(httpClient, config);
    this.quotas = new QuotasService(httpClient, config);
    this.inferenceEndpoints = new InferenceEndpointsService(httpClient, config);
    this.organizationData = new OrganizationDataService(httpClient, config);
    this.webhookSecretKey = new WebhookSecretKeyService(httpClient, config);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  public void setApiKey(String apiKey) {
    ApiKeyAuthConfig apiKeyAuthConfig = this.config.getApiKeyAuthConfig();
    apiKeyAuthConfig.setApiKey(apiKey);
  }

  public void setApiKeyHeader(String apiKeyHeader) {
    ApiKeyAuthConfig apiKeyAuthConfig = this.config.getApiKeyAuthConfig();
    apiKeyAuthConfig.setApiKeyHeader(apiKeyHeader);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
