package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an update container object
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainer {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String image;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Resources resources;

  /**
   * Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<String> command;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  @JsonProperty("environment_variables")
  private Map<String, String> environmentVariables;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private UpdateContainerLogging logging;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("registry_authentication")
  private UpdateContainerRegistryAuthentication registryAuthentication;
}
