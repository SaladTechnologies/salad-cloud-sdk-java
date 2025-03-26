package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<String> command;

  /**
   * Environment variables to set in the container.
   */
  @JsonProperty("environment_variables")
  private Map<String, String> environmentVariables;

  /**
   * The container image to use.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String image;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private Boolean imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private UpdateContainerLogging logging;

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

  /**
   * Defines the resource specifications that can be modified for a container group, including CPU, memory, GPU classes, and storage allocations.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerResourceUpdateSchema resources;
}
