package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Configuration for sending container logs to an HTTP endpoint. Defines how logs are formatted, compressed, and transmitted.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerLoggingConfigurationHttp2 {

  /**
   * The hostname or IP address of the HTTP logging endpoint
   */
  @NonNull
  private String host;

  /**
   * The port number of the HTTP logging endpoint (1-65535)
   */
  @NonNull
  private Long port;

  /**
   * The format in which logs will be delivered
   */
  @NonNull
  private ContainerLoggingHttpFormat format;

  /**
   * The compression algorithm to apply to logs before transmission
   */
  @NonNull
  private ContainerLoggingHttpCompression compression;

  /**
   * Optional username for HTTP authentication
   */
  @JsonProperty("user")
  private JsonNullable<String> user;

  /**
   * Optional password for HTTP authentication
   */
  @JsonProperty("password")
  private JsonNullable<String> password;

  /**
   * Optional URL path for the HTTP endpoint
   */
  @JsonProperty("path")
  private JsonNullable<String> path;

  /**
   * Optional HTTP headers to include in log transmission requests
   */
  @JsonProperty("headers")
  private JsonNullable<List<ContainerLoggingHttpHeader>> headers;

  @JsonIgnore
  public String getUser() {
    return user.orElse(null);
  }

  @JsonIgnore
  public String getPassword() {
    return password.orElse(null);
  }

  @JsonIgnore
  public String getPath() {
    return path.orElse(null);
  }

  @JsonIgnore
  public List<ContainerLoggingHttpHeader> getHeaders() {
    return headers.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerLoggingConfigurationHttp2Builder {

    private JsonNullable<String> user = JsonNullable.undefined();

    @JsonProperty("user")
    public ContainerLoggingConfigurationHttp2Builder user(String value) {
      this.user = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> password = JsonNullable.undefined();

    @JsonProperty("password")
    public ContainerLoggingConfigurationHttp2Builder password(String value) {
      this.password = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> path = JsonNullable.undefined();

    @JsonProperty("path")
    public ContainerLoggingConfigurationHttp2Builder path(String value) {
      this.path = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<ContainerLoggingHttpHeader>> headers = JsonNullable.undefined();

    @JsonProperty("headers")
    public ContainerLoggingConfigurationHttp2Builder headers(List<ContainerLoggingHttpHeader> value) {
      if (value == null) {
        throw new IllegalStateException("headers cannot be null");
      }
      this.headers = JsonNullable.of(value);
      return this;
    }
  }
}
