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
 * Represents a request to create a container group, which manages a collection of container instances with shared configuration and scaling policies
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupCreationRequest {

  /**
   * Determines whether the container group should start automatically when created (true) or remain stopped until manually started (false)
   */
  @NonNull
  @JsonProperty("autostart_policy")
  private Boolean autostartPolicy;

  /**
   * Configuration for creating a container within a container group. Defines the container image, resource requirements, environment variables, and other settings needed to deploy and run the container.
   */
  @NonNull
  private ContainerConfiguration container;

  /**
   * Unique identifier for the container group that must follow DNS naming conventions (lowercase alphanumeric with hyphens)
   */
  @NonNull
  private String name;

  /**
   * Number of container instances to deploy and maintain for this container group
   */
  @NonNull
  private Long replicas;

  /**
   * Specifies the policy for restarting containers when they exit or fail.
   */
  @NonNull
  @JsonProperty("restart_policy")
  private ContainerRestartPolicy restartPolicy;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonProperty("country_codes")
  private JsonNullable<List<CountryCode>> countryCodes;

  /**
   * Human-readable name for the container group that can include spaces and special characters, used for display purposes
   */
  @JsonProperty("display_name")
  private JsonNullable<String> displayName;

  /**
   * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
   */
  @JsonProperty("liveness_probe")
  private JsonNullable<ContainerGroupLivenessProbe> livenessProbe;

  /**
   * Network configuration for container groups specifying connectivity parameters, including authentication, protocol, and timeout settings
   */
  @JsonProperty("networking")
  private JsonNullable<CreateContainerGroupNetworking> networking;

  /**
   * Defines configuration for automatically scaling container instances based on queue length. The autoscaler monitors a queue and adjusts the number of running replicas to maintain the desired queue length.
   */
  @JsonProperty("queue_autoscaler")
  private JsonNullable<QueueBasedAutoscalerConfiguration> queueAutoscaler;

  /**
   * Configuration for connecting a container group to a message queue system, enabling asynchronous communication between services.
   */
  @JsonProperty("queue_connection")
  private JsonNullable<ContainerGroupQueueConnection> queueConnection;

  /**
   * Defines how to check if a container is ready to serve traffic. The readiness probe determines whether the container's application is ready to accept traffic. If the readiness probe fails, the container is considered not ready and traffic will not be sent to it.
   */
  @JsonProperty("readiness_probe")
  private JsonNullable<ContainerGroupReadinessProbe> readinessProbe;

  /**
   * List of scaling action configurations
   */
  @JsonProperty("scaling-actions")
  private JsonNullable<List<ContainerGroupScalingAction>> scalingActions;

  /**
   * Indicates if scheduled scaling is enabled
   */
  @JsonProperty("scheduled-scaling-enabled")
  private JsonNullable<Boolean> scheduledScalingEnabled;

  /**
   * Defines a probe that checks if a container application has started successfully. Startup probes help prevent applications from being prematurely marked as unhealthy during initialization. The probe can use HTTP requests, TCP connections, gRPC calls, or shell commands to determine startup status.
   */
  @JsonProperty("startup_probe")
  private JsonNullable<ContainerGroupStartupProbe> startupProbe;

  @JsonIgnore
  public List<CountryCode> getCountryCodes() {
    return countryCodes.orElse(null);
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupLivenessProbe getLivenessProbe() {
    return livenessProbe.orElse(null);
  }

  @JsonIgnore
  public CreateContainerGroupNetworking getNetworking() {
    return networking.orElse(null);
  }

  @JsonIgnore
  public QueueBasedAutoscalerConfiguration getQueueAutoscaler() {
    return queueAutoscaler.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupQueueConnection getQueueConnection() {
    return queueConnection.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupReadinessProbe getReadinessProbe() {
    return readinessProbe.orElse(null);
  }

  @JsonIgnore
  public List<ContainerGroupScalingAction> getScalingActions() {
    return scalingActions.orElse(null);
  }

  @JsonIgnore
  public Boolean getScheduledScalingEnabled() {
    return scheduledScalingEnabled.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupStartupProbe getStartupProbe() {
    return startupProbe.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupCreationRequestBuilder {

    private JsonNullable<List<CountryCode>> countryCodes = JsonNullable.undefined();

    @JsonProperty("country_codes")
    public ContainerGroupCreationRequestBuilder countryCodes(List<CountryCode> value) {
      if (value == null) {
        throw new IllegalStateException("countryCodes cannot be null");
      }
      this.countryCodes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> displayName = JsonNullable.undefined();

    @JsonProperty("display_name")
    public ContainerGroupCreationRequestBuilder displayName(String value) {
      if (value == null) {
        throw new IllegalStateException("displayName cannot be null");
      }
      this.displayName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupLivenessProbe> livenessProbe = JsonNullable.undefined();

    @JsonProperty("liveness_probe")
    public ContainerGroupCreationRequestBuilder livenessProbe(ContainerGroupLivenessProbe value) {
      this.livenessProbe = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<CreateContainerGroupNetworking> networking = JsonNullable.undefined();

    @JsonProperty("networking")
    public ContainerGroupCreationRequestBuilder networking(CreateContainerGroupNetworking value) {
      if (value == null) {
        throw new IllegalStateException("networking cannot be null");
      }
      this.networking = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<QueueBasedAutoscalerConfiguration> queueAutoscaler = JsonNullable.undefined();

    @JsonProperty("queue_autoscaler")
    public ContainerGroupCreationRequestBuilder queueAutoscaler(QueueBasedAutoscalerConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("queueAutoscaler cannot be null");
      }
      this.queueAutoscaler = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupQueueConnection> queueConnection = JsonNullable.undefined();

    @JsonProperty("queue_connection")
    public ContainerGroupCreationRequestBuilder queueConnection(ContainerGroupQueueConnection value) {
      if (value == null) {
        throw new IllegalStateException("queueConnection cannot be null");
      }
      this.queueConnection = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupReadinessProbe> readinessProbe = JsonNullable.undefined();

    @JsonProperty("readiness_probe")
    public ContainerGroupCreationRequestBuilder readinessProbe(ContainerGroupReadinessProbe value) {
      this.readinessProbe = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<ContainerGroupScalingAction>> scalingActions = JsonNullable.undefined();

    @JsonProperty("scaling-actions")
    public ContainerGroupCreationRequestBuilder scalingActions(List<ContainerGroupScalingAction> value) {
      if (value == null) {
        throw new IllegalStateException("scalingActions cannot be null");
      }
      this.scalingActions = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> scheduledScalingEnabled = JsonNullable.undefined();

    @JsonProperty("scheduled-scaling-enabled")
    public ContainerGroupCreationRequestBuilder scheduledScalingEnabled(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("scheduledScalingEnabled cannot be null");
      }
      this.scheduledScalingEnabled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupStartupProbe> startupProbe = JsonNullable.undefined();

    @JsonProperty("startup_probe")
    public ContainerGroupCreationRequestBuilder startupProbe(ContainerGroupStartupProbe value) {
      this.startupProbe = JsonNullable.of(value);
      return this;
    }
  }
}
