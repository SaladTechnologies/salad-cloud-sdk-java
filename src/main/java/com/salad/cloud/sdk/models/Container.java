package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.openapitools.jackson.nullable.JsonNullable;

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
  private JsonNullable<Map<String, String>> environmentVariables;

  /**
   * SHA-256 hash (64-character hexadecimal string)
   */
  @JsonProperty("hash")
  private JsonNullable<String> hash;

  /**
   * The container image caching.
   */
  @JsonProperty("image_caching")
  private JsonNullable<Boolean> imageCaching;

  /**
   * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
   */
  @JsonProperty("logging")
  private JsonNullable<ContainerLogging> logging;

  /**
   * Size of the container in bytes.
   */
  @JsonProperty("size")
  private JsonNullable<Long> size;

  @JsonIgnore
  public Map<String, String> getEnvironmentVariables() {
    return environmentVariables.orElse(null);
  }

  @JsonIgnore
  public String getHash() {
    return hash.orElse(null);
  }

  @JsonIgnore
  public Boolean getImageCaching() {
    return imageCaching.orElse(null);
  }

  @JsonIgnore
  public ContainerLogging getLogging() {
    return logging.orElse(null);
  }

  @JsonIgnore
  public Long getSize() {
    return size.orElse(null);
  }

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

    private JsonNullable<Map<String, String>> environmentVariables = JsonNullable.undefined();

    @JsonProperty("environment_variables")
    public ContainerBuilder environmentVariables(Map<String, String> value) {
      if (value == null) {
        throw new IllegalStateException("environmentVariables cannot be null");
      }
      this.environmentVariables = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hash = JsonNullable.undefined();

    @JsonProperty("hash")
    public ContainerBuilder hash(String value) {
      if (value == null) {
        throw new IllegalStateException("hash cannot be null");
      }
      this.hash = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> imageCaching = JsonNullable.undefined();

    @JsonProperty("image_caching")
    public ContainerBuilder imageCaching(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("imageCaching cannot be null");
      }
      this.imageCaching = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerLogging> logging = JsonNullable.undefined();

    @JsonProperty("logging")
    public ContainerBuilder logging(ContainerLogging value) {
      if (value == null) {
        throw new IllegalStateException("logging cannot be null");
      }
      this.logging = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> size = JsonNullable.undefined();

    @JsonProperty("size")
    public ContainerBuilder size(Long value) {
      if (value == null) {
        throw new IllegalStateException("size cannot be null");
      }
      this.size = JsonNullable.of(value);
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
