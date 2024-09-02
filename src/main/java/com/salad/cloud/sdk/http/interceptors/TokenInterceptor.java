package com.salad.cloud.sdk.http.interceptors;

import java.io.IOException;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Builder
public class TokenInterceptor implements Interceptor {

  @Getter
  @Setter
  @NonNull
  private String header;

  @Getter
  @Setter
  private String prefix;

  @Getter
  @Setter
  private String token;

  @Override
  public Response intercept(Chain chain) throws IOException {
    return chain.proceed(addTokenToRequest(chain.request()));
  }

  private Request addTokenToRequest(Request request) {
    if (this.header.isEmpty() || this.token == null || this.token.isEmpty()) {
      return request;
    }

    String value = this.prefix == null || this.prefix.isEmpty() ? this.token : this.prefix + " " + this.token;

    return request.newBuilder().addHeader(this.header, value).build();
  }
}
