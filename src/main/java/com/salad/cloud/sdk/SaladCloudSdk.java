package com.salad.cloud.sdk;

import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.http.Environment;
import com.salad.cloud.sdk.http.interceptors.DefaultHeadersInterceptor;
import com.salad.cloud.sdk.http.interceptors.RetryInterceptor;
import com.salad.cloud.sdk.http.interceptors.TokenInterceptor;
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

  private final TokenInterceptor apiKeyAuthInterceptor;

  public SaladCloudSdk() {
    // Default configs
    this(SaladCloudSdkConfig.builder().build());
  }

  public SaladCloudSdk(SaladCloudSdkConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    final ApiKeyAuthConfig apiKeyAuthConfig = config.getApiKeyAuthConfig();
    this.apiKeyAuthInterceptor =
      TokenInterceptor.builder().header(apiKeyAuthConfig.getApiKeyHeader()).token(apiKeyAuthConfig.getApiKey()).build();

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(apiKeyAuthInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.containerGroups = new ContainerGroupsService(httpClient, serverUrl);
    this.workloadErrors = new WorkloadErrorsService(httpClient, serverUrl);
    this.systemLogs = new SystemLogsService(httpClient, serverUrl);
    this.queues = new QueuesService(httpClient, serverUrl);
    this.quotas = new QuotasService(httpClient, serverUrl);
    this.inferenceEndpoints = new InferenceEndpointsService(httpClient, serverUrl);
    this.organizationData = new OrganizationDataService(httpClient, serverUrl);
    this.webhookSecretKey = new WebhookSecretKeyService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.containerGroups.setBaseUrl(baseUrl);
    this.workloadErrors.setBaseUrl(baseUrl);
    this.systemLogs.setBaseUrl(baseUrl);
    this.queues.setBaseUrl(baseUrl);
    this.quotas.setBaseUrl(baseUrl);
    this.inferenceEndpoints.setBaseUrl(baseUrl);
    this.organizationData.setBaseUrl(baseUrl);
    this.webhookSecretKey.setBaseUrl(baseUrl);
  }

  public void setApiKey(String apiKey) {
    this.apiKeyAuthInterceptor.setToken(apiKey);
  }

  public void setApiKeyHeader(String apiKeyHeader) {
    this.apiKeyAuthInterceptor.setHeader(apiKeyHeader);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
