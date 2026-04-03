package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ContainerLoggingConfigurationHttp1 {

  /**
   * The compression algorithm to apply to logs before transmission
   */
  @NonNull
  private ContainerLoggingHttpCompression compression;

  /**
   * The format in which logs will be delivered
   */
  @NonNull
  private ContainerLoggingHttpFormat format;

  /**
   * Optional HTTP headers to include in log transmission requests
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<ContainerLoggingHttpHeader> headers;

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
   * Optional username for HTTP authentication
   */
  @JsonProperty("user")
  private JsonNullable<String> user;

  @JsonIgnore
  public String getPassword() {
    return password.orElse(null);
  }

  @JsonIgnore
  public String getPath() {
    return path.orElse(null);
  }

  @JsonIgnore
  public String getUser() {
    return user.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerLoggingConfigurationHttp1Builder {

    /**
     * Flag to track if the headers property has been set.
     */
    private boolean headers$set = false;

    public ContainerLoggingConfigurationHttp1Builder headers(List<ContainerLoggingHttpHeader> headers) {
      this.headers$set = true;
      this.headers = headers;
      return this;
    }

    private JsonNullable<String> password = JsonNullable.undefined();

    @JsonProperty("password")
    public ContainerLoggingConfigurationHttp1Builder password(String value) {
      this.password = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> path = JsonNullable.undefined();

    @JsonProperty("path")
    public ContainerLoggingConfigurationHttp1Builder path(String value) {
      this.path = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> user = JsonNullable.undefined();

    @JsonProperty("user")
    public ContainerLoggingConfigurationHttp1Builder user(String value) {
      this.user = JsonNullable.of(value);
      return this;
    }

    public ContainerLoggingConfigurationHttp1 build() {
      if (!headers$set) {
        throw new IllegalStateException("headers is required");
      }
      return new ContainerLoggingConfigurationHttp1(compression, format, headers, host, port, password, path, user);
    }
  }
}
