package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents an update container object
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainer {

  /**
   * Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image.
   */
  @JsonProperty("command")
  private JsonNullable<List<String>> command;

  /**
   * Environment variables to set in the container.
   */
  @JsonProperty("environment_variables")
  private JsonNullable<Map<String, String>> environmentVariables;

  /**
   * The container image to use.
   */
  @JsonProperty("image")
  private JsonNullable<String> image;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private JsonNullable<Boolean> imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  @JsonProperty("logging")
  private JsonNullable<UpdateContainerLogging> logging;

  /**
   * Specifies the priority level for container group execution, which determines resource allocation and scheduling precedence.
   */
  @JsonProperty("priority")
  private JsonNullable<ContainerGroupPriority> priority;

  /**
   * Authentication configuration for various container registry types, including AWS ECR, Docker Hub, GCP GAR, GCP GCR, and basic authentication.
   */
  @JsonProperty("registry_authentication")
  private JsonNullable<ContainerRegistryAuthentication> registryAuthentication;

  /**
   * Defines the resource specifications that can be modified for a container group, including CPU, memory, GPU classes, and storage allocations.
   */
  @JsonProperty("resources")
  private JsonNullable<ContainerResourceUpdateSchema> resources;

  @JsonIgnore
  public List<String> getCommand() {
    return command.orElse(null);
  }

  @JsonIgnore
  public Map<String, String> getEnvironmentVariables() {
    return environmentVariables.orElse(null);
  }

  @JsonIgnore
  public String getImage() {
    return image.orElse(null);
  }

  @JsonIgnore
  public Boolean getImageCaching() {
    return imageCaching.orElse(null);
  }

  @JsonIgnore
  public UpdateContainerLogging getLogging() {
    return logging.orElse(null);
  }

  @JsonIgnore
  public ContainerGroupPriority getPriority() {
    return priority.orElse(null);
  }

  @JsonIgnore
  public ContainerRegistryAuthentication getRegistryAuthentication() {
    return registryAuthentication.orElse(null);
  }

  @JsonIgnore
  public ContainerResourceUpdateSchema getResources() {
    return resources.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UpdateContainerBuilder {

    private JsonNullable<List<String>> command = JsonNullable.undefined();

    @JsonProperty("command")
    public UpdateContainerBuilder command(List<String> value) {
      this.command = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Map<String, String>> environmentVariables = JsonNullable.undefined();

    @JsonProperty("environment_variables")
    public UpdateContainerBuilder environmentVariables(Map<String, String> value) {
      if (value == null) {
        throw new IllegalStateException("environmentVariables cannot be null");
      }
      this.environmentVariables = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> image = JsonNullable.undefined();

    @JsonProperty("image")
    public UpdateContainerBuilder image(String value) {
      this.image = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> imageCaching = JsonNullable.undefined();

    @JsonProperty("image_caching")
    public UpdateContainerBuilder imageCaching(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("imageCaching cannot be null");
      }
      this.imageCaching = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<UpdateContainerLogging> logging = JsonNullable.undefined();

    @JsonProperty("logging")
    public UpdateContainerBuilder logging(UpdateContainerLogging value) {
      this.logging = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupPriority> priority = JsonNullable.undefined();

    @JsonProperty("priority")
    public UpdateContainerBuilder priority(ContainerGroupPriority value) {
      this.priority = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthentication> registryAuthentication = JsonNullable.undefined();

    @JsonProperty("registry_authentication")
    public UpdateContainerBuilder registryAuthentication(ContainerRegistryAuthentication value) {
      if (value == null) {
        throw new IllegalStateException("registryAuthentication cannot be null");
      }
      this.registryAuthentication = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerResourceUpdateSchema> resources = JsonNullable.undefined();

    @JsonProperty("resources")
    public UpdateContainerBuilder resources(ContainerResourceUpdateSchema value) {
      this.resources = JsonNullable.of(value);
      return this;
    }
  }
}
