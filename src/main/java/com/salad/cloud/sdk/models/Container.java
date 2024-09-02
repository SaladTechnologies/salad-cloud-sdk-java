package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a container
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class Container {

  @NonNull
  @Length(min = 1, max = 1024)
  private String image;

  /**
   * Represents a container resource requirements
   */
  @NonNull
  private ContainerResourceRequirements resources;

  @NonNull
  private List<String> command;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerGroupPriority priority;

  private Long size;

  private String hash;

  @JsonProperty("environment_variables")
  private Map<String, String> environmentVariables;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private ContainerLogging logging;
}
