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
public class RegistryAuthenticationAwsEcr1 {

  @NonNull
  @JsonProperty("access_key_id")
  private String accessKeyId;

  @NonNull
  @JsonProperty("secret_access_key")
  private String secretAccessKey;
}
