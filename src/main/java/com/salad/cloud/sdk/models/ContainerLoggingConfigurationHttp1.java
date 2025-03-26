package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private ContainerHttpLoggingConfigurationFormat1 format;

  /**
   * Optional HTTP headers to include in log transmission requests
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<ContainerLoggingHttpHeader> headers;

  /**
   * The compression algorithm to apply to logs before transmission
   */
  @NonNull
  private ContainerHttpLoggingConfigurationCompression1 compression;

  /**
   * Optional username for HTTP authentication
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String user;

  /**
   * Optional password for HTTP authentication
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String password;

  /**
   * Optional URL path for the HTTP endpoint
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String path;

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

    public ContainerLoggingConfigurationHttp1 build() {
      if (!headers$set) {
        throw new IllegalStateException("headers is required");
      }
      return new ContainerLoggingConfigurationHttp1(host, port, format, headers, compression, user, password, path);
    }
  }
}
