package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a request to update a container group
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupPatch {

  /**
   * Represents an update container object
   */
  @JsonProperty("container")
  private JsonNullable<UpdateContainer> container;

  /**
   * List of countries nodes must be located in. Remove this field to permit nodes from any country.
   */
  @JsonProperty("country_codes")
  private JsonNullable<List<CountryCode>> countryCodes;

  /**
   * The display name for the container group. If null is provided, the display name will be set to the container group name.
   */
  @JsonProperty("display_name")
  private JsonNullable<String> displayName;

  /**
   * Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy
   */
  @JsonProperty("liveness_probe")
  private JsonNullable<ContainerGroupLivenessProbe> livenessProbe;

  /**
   * Represents update container group networking parameters
   */
  @JsonProperty("networking")
  private JsonNullable<UpdateContainerGroupNetworking> networking;

  /**
   * Defines configuration for automatically scaling container instances based on queue length. The autoscaler monitors a queue and adjusts the number of running replicas to maintain the desired queue length.
   */
  @JsonProperty("queue_autoscaler")
  private JsonNullable<QueueBasedAutoscalerConfiguration> queueAutoscaler;

  /**
   * Defines how to check if a container is ready to serve traffic. The readiness probe determines whether the container's application is ready to accept traffic. If the readiness probe fails, the container is considered not ready and traffic will not be sent to it.
   */
  @JsonProperty("readiness_probe")
  private JsonNullable<ContainerGroupReadinessProbe> readinessProbe;

  /**
   * The desired number of instances for your container group deployment.
   */
  @JsonProperty("replicas")
  private JsonNullable<Long> replicas;

  /**
   * List of scaling actions configurations
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
  public UpdateContainer getContainer() {
    return container.orElse(null);
  }

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
  public UpdateContainerGroupNetworking getNetworking() {
    return networking.orElse(null);
  }

  @JsonIgnore
  public QueueBasedAutoscalerConfiguration getQueueAutoscaler() {
    return queueAutoscaler.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupReadinessProbe getReadinessProbe() {
    return readinessProbe.orElse(null);
  }

  @JsonIgnore
  public Long getReplicas() {
    return replicas.orElse(null);
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
  public static class ContainerGroupPatchBuilder {

    private JsonNullable<UpdateContainer> container = JsonNullable.undefined();

    @JsonProperty("container")
    public ContainerGroupPatchBuilder container(UpdateContainer value) {
      this.container = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<CountryCode>> countryCodes = JsonNullable.undefined();

    @JsonProperty("country_codes")
    public ContainerGroupPatchBuilder countryCodes(List<CountryCode> value) {
      this.countryCodes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> displayName = JsonNullable.undefined();

    @JsonProperty("display_name")
    public ContainerGroupPatchBuilder displayName(String value) {
      this.displayName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupLivenessProbe> livenessProbe = JsonNullable.undefined();

    @JsonProperty("liveness_probe")
    public ContainerGroupPatchBuilder livenessProbe(ContainerGroupLivenessProbe value) {
      this.livenessProbe = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<UpdateContainerGroupNetworking> networking = JsonNullable.undefined();

    @JsonProperty("networking")
    public ContainerGroupPatchBuilder networking(UpdateContainerGroupNetworking value) {
      if (value == null) {
        throw new IllegalStateException("networking cannot be null");
      }
      this.networking = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<QueueBasedAutoscalerConfiguration> queueAutoscaler = JsonNullable.undefined();

    @JsonProperty("queue_autoscaler")
    public ContainerGroupPatchBuilder queueAutoscaler(QueueBasedAutoscalerConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("queueAutoscaler cannot be null");
      }
      this.queueAutoscaler = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupReadinessProbe> readinessProbe = JsonNullable.undefined();

    @JsonProperty("readiness_probe")
    public ContainerGroupPatchBuilder readinessProbe(ContainerGroupReadinessProbe value) {
      this.readinessProbe = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> replicas = JsonNullable.undefined();

    @JsonProperty("replicas")
    public ContainerGroupPatchBuilder replicas(Long value) {
      this.replicas = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<ContainerGroupScalingAction>> scalingActions = JsonNullable.undefined();

    @JsonProperty("scaling-actions")
    public ContainerGroupPatchBuilder scalingActions(List<ContainerGroupScalingAction> value) {
      if (value == null) {
        throw new IllegalStateException("scalingActions cannot be null");
      }
      this.scalingActions = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> scheduledScalingEnabled = JsonNullable.undefined();

    @JsonProperty("scheduled-scaling-enabled")
    public ContainerGroupPatchBuilder scheduledScalingEnabled(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("scheduledScalingEnabled cannot be null");
      }
      this.scheduledScalingEnabled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupStartupProbe> startupProbe = JsonNullable.undefined();

    @JsonProperty("startup_probe")
    public ContainerGroupPatchBuilder startupProbe(ContainerGroupStartupProbe value) {
      this.startupProbe = JsonNullable.of(value);
      return this;
    }
  }
}
