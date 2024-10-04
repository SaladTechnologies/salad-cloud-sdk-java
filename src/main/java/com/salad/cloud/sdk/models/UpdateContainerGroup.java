package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to update a container group
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerGroup {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("display_name")
  private String displayName;

  /**
   * Represents an update container object
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private UpdateContainer container;

  @JsonInclude(JsonInclude.Include.ALWAYS)
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

  /**
   * Represents the autoscaling rules for a queue
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("queue_autoscaler")
  private QueueAutoscaler queueAutoscaler;
}
