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
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to create a container group
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerGroup {

  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
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
  @Max(250)
  @Min(0)
  private Long replicas;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
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
  @JsonProperty("queue_autoscaler")
  private QueueAutoscaler queueAutoscaler;
}
