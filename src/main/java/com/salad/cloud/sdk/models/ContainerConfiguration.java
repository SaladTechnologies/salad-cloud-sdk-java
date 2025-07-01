package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Configuration for creating a container within a container group. Defines the container image, resource requirements, environment variables, and other settings needed to deploy and run the container.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerConfiguration {

  /**
   * The container image.
   */
  @NonNull
  private String image;

  /**
   * Specifies the resource requirements for creating a container.
   */
  @NonNull
  private CreateContainerResourceRequirements resources;

  /**
   * Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image. Each element in the array represents a command segment or argument.
   */
  @JsonProperty("command")
  private JsonNullable<List<String>> command;

  /**
   * Key-value pairs of environment variables to set within the container. These variables will be available to processes running inside the container.
   */
  @JsonProperty("environment_variables")
  private JsonNullable<Map<String, String>> environmentVariables;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private JsonNullable<Boolean> imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  @JsonProperty("logging")
  private JsonNullable<ContainerConfigurationLogging> logging;

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

  @JsonIgnore
  public List<String> getCommand() {
    return command.orElse(null);
  }

  @JsonIgnore
  public Map<String, String> getEnvironmentVariables() {
    return environmentVariables.orElse(null);
  }

  @JsonIgnore
  public Boolean getImageCaching() {
    return imageCaching.orElse(null);
  }

  @JsonIgnore
  public ContainerConfigurationLogging getLogging() {
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

  // Overwrite lombok builder methods
  public static class ContainerConfigurationBuilder {

    private JsonNullable<List<String>> command = JsonNullable.undefined();

    @JsonProperty("command")
    public ContainerConfigurationBuilder command(List<String> value) {
      this.command = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Map<String, String>> environmentVariables = JsonNullable.undefined();

    @JsonProperty("environment_variables")
    public ContainerConfigurationBuilder environmentVariables(Map<String, String> value) {
      if (value == null) {
        throw new IllegalStateException("environmentVariables cannot be null");
      }
      this.environmentVariables = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> imageCaching = JsonNullable.undefined();

    @JsonProperty("image_caching")
    public ContainerConfigurationBuilder imageCaching(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("imageCaching cannot be null");
      }
      this.imageCaching = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerConfigurationLogging> logging = JsonNullable.undefined();

    @JsonProperty("logging")
    public ContainerConfigurationBuilder logging(ContainerConfigurationLogging value) {
      if (value == null) {
        throw new IllegalStateException("logging cannot be null");
      }
      this.logging = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerGroupPriority> priority = JsonNullable.undefined();

    @JsonProperty("priority")
    public ContainerConfigurationBuilder priority(ContainerGroupPriority value) {
      this.priority = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthentication> registryAuthentication = JsonNullable.undefined();

    @JsonProperty("registry_authentication")
    public ContainerConfigurationBuilder registryAuthentication(ContainerRegistryAuthentication value) {
      if (value == null) {
        throw new IllegalStateException("registryAuthentication cannot be null");
      }
      this.registryAuthentication = JsonNullable.of(value);
      return this;
    }
  }
}
