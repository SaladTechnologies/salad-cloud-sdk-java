package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import com.salad.cloud.sdk.validation.annotation.Pattern;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to update a container group
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerGroup {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
  @JsonProperty("display_name")
  private String displayName;

  /**
   * Represents an update container object
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private UpdateContainer container;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Max(250)
  @Min(0)
  private Long replicas;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * Represents update container group networking parameters
   */
  private UpdateContainerGroupNetworking networking;

  /**
   * Represents the container group liveness probe
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("liveness_probe")
  private ContainerGroupLivenessProbe livenessProbe;

  /**
   * Represents the container group readiness probe
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("readiness_probe")
  private ContainerGroupReadinessProbe readinessProbe;

  /**
   * Represents the container group startup probe
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("startup_probe")
  private ContainerGroupStartupProbe startupProbe;
}
