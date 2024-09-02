package com.salad.cloud.sdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.sdk.exceptions.ApiException;
import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.util.RequestBuilder;
import com.salad.cloud.sdk.models.WebhookSecretKey;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * WebhookSecretKeyService Service
 */
public class WebhookSecretKeyService extends BaseService {

  public WebhookSecretKeyService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Gets the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public WebhookSecretKey getWebhookSecretKey(@NonNull String organizationName) throws ApiException {
    Request request = this.buildGetWebhookSecretKeyRequest(organizationName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<WebhookSecretKey>() {});
  }

  /**
   * Gets the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public CompletableFuture<WebhookSecretKey> getWebhookSecretKeyAsync(@NonNull String organizationName)
    throws ApiException {
    Request request = this.buildGetWebhookSecretKeyRequest(organizationName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<WebhookSecretKey>() {});
    });
  }

  private Request buildGetWebhookSecretKeyRequest(@NonNull String organizationName) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "organizations/{organization_name}/webhook-secret-key")
      .setPathParameter("organization_name", organizationName)
      .build();
  }

  /**
   * Updates the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public WebhookSecretKey updateWebhookSecretKey(@NonNull String organizationName) throws ApiException {
    Request request = this.buildUpdateWebhookSecretKeyRequest(organizationName);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<WebhookSecretKey>() {});
  }

  /**
   * Updates the webhook secret key
   *
   * @param organizationName String Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization.
   * @return response of {@code WebhookSecretKey}
   */
  public CompletableFuture<WebhookSecretKey> updateWebhookSecretKeyAsync(@NonNull String organizationName)
    throws ApiException {
    Request request = this.buildUpdateWebhookSecretKeyRequest(organizationName);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<WebhookSecretKey>() {});
    });
  }

  private Request buildUpdateWebhookSecretKeyRequest(@NonNull String organizationName) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "organizations/{organization_name}/webhook-secret-key")
      .setPathParameter("organization_name", organizationName)
      .build();
  }
}
