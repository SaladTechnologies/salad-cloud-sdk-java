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
 * Represents a container group
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroup {

  @NonNull
  private String id;

  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
  private String name;

  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
  @JsonProperty("display_name")
  private String displayName;

  /**
   * Represents a container
   */
  @NonNull
  private Container container;

  @NonNull
  @JsonProperty("autostart_policy")
  private Boolean autostartPolicy;

  @NonNull
  @JsonProperty("restart_policy")
  private ContainerRestartPolicy restartPolicy;

  @NonNull
  @Max(100)
  @Min(0)
  private Long replicas;

  /**
   * Represents a container group state
   */
  @NonNull
  @JsonProperty("current_state")
  private ContainerGroupState currentState;

  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  @NonNull
  @JsonProperty("pending_change")
  private Boolean pendingChange;

  @NonNull
  @Min(1)
  private Long version;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonProperty("country_codes")
  private List<CountryCode> countryCodes;

  /**
   * Represents container group networking parameters
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupNetworking networking;

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
