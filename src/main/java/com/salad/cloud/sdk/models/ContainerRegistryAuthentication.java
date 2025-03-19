package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Authentication configuration for various container registry types, including AWS ECR, Docker Hub, GCP GAR, GCP GCR, and basic authentication.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerRegistryAuthentication {

  /**
   * Authentication details for AWS Elastic Container Registry (ECR)
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("aws_ecr")
  private ContainerRegistryAuthenticationAwsEcr awsEcr;

  /**
   * Basic username and password authentication for generic container registries
   */
  private ContainerRegistryAuthenticationBasic basic;

  /**
   * Authentication details for Docker Hub registry
   */
  @JsonProperty("docker_hub")
  private ContainerRegistryAuthenticationDockerHub dockerHub;

  /**
   * Authentication details for Google Artifact Registry (GAR)
   */
  @JsonProperty("gcp_gar")
  private ContainerRegistryAuthenticationGcpGar gcpGar;

  /**
   * Authentication details for Google Container Registry (GCR)
   */
  @JsonProperty("gcp_gcr")
  private ContainerRegistryAuthenticationGcpGcr gcpGcr;
}
