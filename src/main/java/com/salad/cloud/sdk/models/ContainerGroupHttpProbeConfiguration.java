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
 * Defines HTTP probe configuration for container health checks within a container group.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupHttpProbeConfiguration {

  /**
   * A collection of HTTP header name-value pairs used for configuring requests and responses in container group endpoints. Each header consists of a name and its corresponding value.
   */
  @NonNull
  private List<ContainerGroupProbeHttpHeader> headers;

  /**
   * The HTTP path that will be probed to check container health.
   */
  @NonNull
  private String path;

  /**
   * The TCP port number to which the HTTP request will be sent.
   */
  @NonNull
  private Long port;

  /**
   * The protocol scheme used for HTTP probe requests in container health checks.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private HttpScheme scheme;

  // Overwrite lombok builder methods
  public static class ContainerGroupHttpProbeConfigurationBuilder {

    /**
     * Flag to track if the scheme property has been set.
     */
    private boolean scheme$set = false;

    public ContainerGroupHttpProbeConfigurationBuilder scheme(HttpScheme scheme) {
      this.scheme$set = true;
      this.scheme = scheme;
      return this;
    }

    public ContainerGroupHttpProbeConfiguration build() {
      if (!scheme$set) {
        throw new IllegalStateException("scheme is required");
      }
      return new ContainerGroupHttpProbeConfiguration(headers, path, port, scheme);
    }
  }
}
