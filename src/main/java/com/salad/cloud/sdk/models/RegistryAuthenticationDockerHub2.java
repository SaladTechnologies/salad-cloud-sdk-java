package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class RegistryAuthenticationDockerHub2 {

  @NonNull
  private String username;

  @NonNull
  @JsonProperty("personal_access_token")
  private String personalAccessToken;
}
