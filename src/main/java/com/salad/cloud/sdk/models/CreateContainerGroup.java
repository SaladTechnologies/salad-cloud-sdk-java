package com.salad.cloud.sdk.models;

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

/**
 * Represents a request to create a container group
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerGroup {

  @NonNull
  private String name;

  /**
   * Represents a container
   */
  @NonNull
  private CreateContainer container;

  @NonNull
  @JsonProperty("autostart_policy")
  private Boolean autostartPolicy;

  @NonNull
  @JsonProperty("restart_policy")
  private ContainerRestartPolicy restartPolicy;

  @NonNull
  private Long replicas;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("display_name")
  private String displayName;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * Represents container group networking parameters
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private CreateContainerGroupNetworking networking;

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
   * Represents container group queue connection
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("queue_connection")
  private ContainerGroupQueueConnection queueConnection;

  /**
   * Represents the autoscaling rules for a queue
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("queue_autoscaler")
  private QueueAutoscaler queueAutoscaler;
}
