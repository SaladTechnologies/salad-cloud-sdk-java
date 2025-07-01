package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents update container group networking parameters
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerGroupNetworking {

  /**
   * The port number to expose on the container group
   */
  @JsonProperty("port")
  private JsonNullable<Long> port;

  @JsonIgnore
  public Long getPort() {
    return port.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UpdateContainerGroupNetworkingBuilder {

    private JsonNullable<Long> port = JsonNullable.undefined();

    @JsonProperty("port")
    public UpdateContainerGroupNetworkingBuilder port(Long value) {
      this.port = JsonNullable.of(value);
      return this;
    }
  }
}
