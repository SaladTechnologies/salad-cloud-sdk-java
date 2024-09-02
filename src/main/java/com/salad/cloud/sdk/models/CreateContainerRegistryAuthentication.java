package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateContainerRegistryAuthentication {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private RegistryAuthenticationBasic1 basic;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gcp_gcr")
  private RegistryAuthenticationGcpGcr1 gcpGcr;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("aws_ecr")
  private RegistryAuthenticationAwsEcr1 awsEcr;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("docker_hub")
  private RegistryAuthenticationDockerHub1 dockerHub;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("gcp_gar")
  private RegistryAuthenticationGcpGar1 gcpGar;
}
