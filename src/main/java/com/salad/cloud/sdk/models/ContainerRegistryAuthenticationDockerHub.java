package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Authentication details for Docker Hub registry
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerRegistryAuthenticationDockerHub {

  /**
   * Docker Hub personal access token (PAT)
   */
  @NonNull
  @JsonProperty("personal_access_token")
  private String personalAccessToken;

  /**
   * Docker Hub username
   */
  @NonNull
  private String username;
}
