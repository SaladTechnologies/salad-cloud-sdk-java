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
 * Represents a container with its configuration and resource requirements.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Container {

  /**
   * List of commands to run inside the container. Each command is a string representing a command-line instruction.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<String> command;

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
   * Environment variables to set in the container.
   */
  @JsonProperty("environment_variables")
  private Map<String, String> environmentVariables;

  /**
   * SHA-256 hash (64-character hexadecimal string)
   */
  private String hash;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private Boolean imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  private ContainerLogging logging;

  /**
   * Size of the container in bytes.
   */
  private Long size;

  // Overwrite lombok builder methods
  public static class ContainerBuilder {

    /**
     * Flag to track if the command property has been set.
     */
    private boolean command$set = false;

    public ContainerBuilder command(List<String> command) {
      this.command$set = true;
      this.command = command;
      return this;
    }

    public Container build() {
      if (!command$set) {
        throw new IllegalStateException("command is required");
      }
      return new Container(command, image, resources, environmentVariables, hash, imageCaching, logging, size);
    }
  }
}
