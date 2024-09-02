package com.salad.cloud.sdk.http.util;

import com.salad.cloud.sdk.http.HttpMethod;
import com.salad.cloud.sdk.http.ModelConverter;
import com.salad.cloud.sdk.http.serialization.PathSerializationStyle;
import com.salad.cloud.sdk.http.serialization.QuerySerializationStyle;
import com.salad.cloud.sdk.http.serialization.SerializationStyle;
import com.salad.cloud.sdk.http.serialization.Serializer;
import java.util.*;
import lombok.NonNull;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public class RequestBuilder {

  @NonNull
  private final String baseUrl;

  @NonNull
  private final String path;

  @NonNull
  private final HttpMethod httpMethod;

  private final HashMap<String, String> pathParameters = new HashMap<>();

  private final List<String> queryParameters = new ArrayList<>();

  private final HashMap<String, String> headers = new HashMap<>();

  private RequestBody body;

  /**
   * Initializes a new instance of {@code RequestBuilder}.
   *
   * @param path The path template to use for the request. Should have path parameters as
   *     placeholders surrounded by brackets (Eg. "/users/{id}", where "id" is a path parameter).
   */
  public RequestBuilder(@NotNull HttpMethod httpMethod, @NotNull String baseUrl, @NotNull String path) {
    this.httpMethod = httpMethod;
    this.baseUrl = baseUrl;
    this.path = path;
  }

  /**
   * Sets a path parameter. If the parameter is not present in the URL template, it will be ignored.
   */
  public RequestBuilder setPathParameter(@NonNull String key, @NonNull Object value) {
    return setPathParameter(key, value, PathSerializationStyle.SIMPLE, false);
  }

  /**
   * Sets a path parameter. If the parameter is not present in the URL template, it will be ignored.
   */
  public RequestBuilder setPathParameter(
    @NonNull String key,
    @NonNull Object value,
    PathSerializationStyle style,
    boolean explode
  ) {
    String serializedValue = Serializer.serialize(key, value, style.style, explode, true);
    pathParameters.put(key, serializedValue);
    return this;
  }

  /**
   * Sets a query parameter.
   */
  public RequestBuilder setQueryParameter(@NonNull String key, @NonNull Object value) {
    return setQueryParameter(key, value, QuerySerializationStyle.FORM, true);
  }

  /**
   * Sets a query parameter.
   */
  public RequestBuilder setQueryParameter(
    @NonNull String key,
    @NonNull Object value,
    QuerySerializationStyle style,
    boolean explode
  ) {
    String serializedValue = Serializer.serialize(key, value, style.style, explode, true);
    queryParameters.add(serializedValue);
    return this;
  }

  public RequestBuilder setOptionalQueryParameter(@NonNull String key, Object value) {
    return setOptionalQueryParameter(key, value, QuerySerializationStyle.FORM, true);
  }

  /**
   * Sets a query parameter if the value is not null.
   */
  public RequestBuilder setOptionalQueryParameter(
    @NonNull String key,
    Object value,
    QuerySerializationStyle style,
    boolean explode
  ) {
    if (value != null) {
      return setQueryParameter(key, value, style, explode);
    }
    return this;
  }

  /**
   * Sets a header.
   */
  public RequestBuilder setHeader(@NonNull String key, @NonNull Object value) {
    return setHeader(key, value, false);
  }

  /**
   * Sets a header.
   */
  public RequestBuilder setHeader(@NonNull String key, @NonNull Object value, boolean explode) {
    String serializedValue = Serializer.serialize(key, value, SerializationStyle.SIMPLE, explode, false);
    headers.put(key, serializedValue);
    return this;
  }

  /**
   * Sets a header if the value is not null.
   */
  public RequestBuilder setOptionalHeader(@NonNull String key, Object value) {
    return setOptionalHeader(key, value, false);
  }

  /**
   * Sets a header if the value is not null.
   */
  public RequestBuilder setOptionalHeader(@NonNull String key, Object value, boolean explode) {
    if (value != null) {
      return setHeader(key, value, explode);
    }
    return this;
  }

  /**
   * Sets the body of the request.
   */
  public RequestBuilder setBody(RequestBody body) {
    this.body = body;
    return this;
  }

  /**
   * Sets the content of the request as JSON.
   */
  public RequestBuilder setJsonContent(Object content) {
    return setJsonContent(content, MediaType.parse("application/json; charset=utf-8"));
  }

  /**
   * Sets the content of the request as JSON.
   */
  public RequestBuilder setJsonContent(Object content, MediaType mediaType) {
    if (content == null) {
      return this;
    }
    setBody(RequestBody.create(Objects.requireNonNull(ModelConverter.modelToJson(content)), mediaType));
    return this;
  }

  /**
   * @return The {@code Request} instance.
   */
  public Request build() {
    String url = buildUrl();
    Request.Builder requestBuilder = new Request.Builder().url(url);

    for (Map.Entry<String, String> entry : headers.entrySet()) {
      requestBuilder.addHeader(entry.getKey(), entry.getValue());
    }

    if (httpMethod.requiresRequestBody() && this.body == null) {
      this.body = RequestBody.create(new byte[0]);
    }

    requestBuilder.method(httpMethod.getMethod(), body);

    return requestBuilder.build();
  }

  private String buildUrl() {
    String path = this.path;

    for (Map.Entry<String, String> entry : pathParameters.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      path = path.replace("{" + key + "}", value);
    }

    String url = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder().addPathSegments(path).build().toString();

    if (!queryParameters.isEmpty()) {
      url += "?" + String.join("&", queryParameters);
    }

    return url;
  }
}
