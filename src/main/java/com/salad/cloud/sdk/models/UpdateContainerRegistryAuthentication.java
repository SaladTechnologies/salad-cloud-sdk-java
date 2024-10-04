package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerRegistryAuthentication {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private RegistryAuthenticationBasic2 basic;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gcp_gcr")
  private RegistryAuthenticationGcpGcr2 gcpGcr;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("aws_ecr")
  private RegistryAuthenticationAwsEcr2 awsEcr;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("docker_hub")
  private RegistryAuthenticationDockerHub2 dockerHub;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gcp_gar")
  private RegistryAuthenticationGcpGar2 gcpGar;
}
