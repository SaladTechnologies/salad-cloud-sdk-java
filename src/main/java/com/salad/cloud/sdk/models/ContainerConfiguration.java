package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
   * Specifies the resource requirements for a container.
   */
  @NonNull
  private ContainerResourceRequirements resources;

  /**
   * Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image. Each element in the array represents a command segment or argument.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<String> command;

  /**
   * Key-value pairs of environment variables to set within the container. These variables will be available to processes running inside the container.
   */
  @JsonProperty("environment_variables")
  private Map<String, String> environmentVariables;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private Boolean imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  private ContainerConfigurationLogging logging;

  /**
   * Specifies the priority level for container group execution, which determines resource allocation and scheduling precedence.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  /**
   * Authentication configuration for various container registry types, including AWS ECR, Docker Hub, GCP GAR, GCP GCR, and basic authentication.
   */
  @JsonProperty("registry_authentication")
  private ContainerRegistryAuthentication registryAuthentication;
}
