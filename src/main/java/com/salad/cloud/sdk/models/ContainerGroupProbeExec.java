package com.salad.cloud.sdk.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Defines the exec action for a probe in a container group. This is used to execute a command inside a container for health checks.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupProbeExec {

  /**
   * The command to execute inside the container. Exit status of 0 is considered successful, any other exit status is considered failure.
   */
  @NonNull
  private List<String> command;
}
