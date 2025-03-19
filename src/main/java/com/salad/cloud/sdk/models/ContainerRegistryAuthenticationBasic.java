package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Basic username and password authentication for generic container registries
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerRegistryAuthenticationBasic {

  /**
   * Username for registry authentication
   */
  @NonNull
  private String username;

  /**
   * Password for registry authentication
   */
  @NonNull
  private String password;
}
