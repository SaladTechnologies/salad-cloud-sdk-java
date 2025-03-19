package com.salad.cloud.sdk.services;

import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.exceptions.ApiException;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class BaseService {

  protected OkHttpClient httpClient;
  protected SaladCloudSdkConfig config;

  public BaseService(OkHttpClient httpClient, SaladCloudSdkConfig config) {
    this.httpClient = httpClient;
    this.config = config;
  }

  protected Response execute(Request request) throws ApiException {
    Response response;
    try {
      response = this.httpClient.newCall(request).execute();
    } catch (IOException e) {
      throw new ApiException(e.getMessage());
    }
    if (response.isSuccessful()) {
      return response;
    } else {
      throw new ApiException(response.code());
    }
  }

  protected CompletableFuture<Response> executeAsync(Request request) {
    CompletableFuture<Response> future = new CompletableFuture<>();
    this.httpClient.newCall(request)
      .enqueue(
        new Callback() {
          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) {
            if (!response.isSuccessful()) {
              ApiException apiException = new ApiException(response.code());
              future.completeExceptionally(apiException);
              return;
            }

            future.complete(response);
          }

          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            ApiException apiException = new ApiException(e.getMessage());
            future.completeExceptionally(apiException);
          }
        }
      );
    return future;
  }
}
