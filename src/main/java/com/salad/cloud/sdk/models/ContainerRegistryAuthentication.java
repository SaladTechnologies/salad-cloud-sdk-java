package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

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
  @JsonProperty("aws_ecr")
  private JsonNullable<ContainerRegistryAuthenticationAwsEcr> awsEcr;

  /**
   * Basic username and password authentication for generic container registries
   */
  @JsonProperty("basic")
  private JsonNullable<ContainerRegistryAuthenticationBasic> basic;

  /**
   * Authentication details for Docker Hub registry
   */
  @JsonProperty("docker_hub")
  private JsonNullable<ContainerRegistryAuthenticationDockerHub> dockerHub;

  /**
   * Authentication details for Google Artifact Registry (GAR)
   */
  @JsonProperty("gcp_gar")
  private JsonNullable<ContainerRegistryAuthenticationGcpGar> gcpGar;

  /**
   * Authentication details for Google Container Registry (GCR)
   */
  @JsonProperty("gcp_gcr")
  private JsonNullable<ContainerRegistryAuthenticationGcpGcr> gcpGcr;

  @JsonIgnore
  public ContainerRegistryAuthenticationAwsEcr getAwsEcr() {
    return awsEcr.orElse(null);
  }

  @JsonIgnore
  public ContainerRegistryAuthenticationBasic getBasic() {
    return basic.orElse(null);
  }

  @JsonIgnore
  public ContainerRegistryAuthenticationDockerHub getDockerHub() {
    return dockerHub.orElse(null);
  }

  @JsonIgnore
  public ContainerRegistryAuthenticationGcpGar getGcpGar() {
    return gcpGar.orElse(null);
  }

  @JsonIgnore
  public ContainerRegistryAuthenticationGcpGcr getGcpGcr() {
    return gcpGcr.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerRegistryAuthenticationBuilder {

    private JsonNullable<ContainerRegistryAuthenticationAwsEcr> awsEcr = JsonNullable.undefined();

    @JsonProperty("aws_ecr")
    public ContainerRegistryAuthenticationBuilder awsEcr(ContainerRegistryAuthenticationAwsEcr value) {
      this.awsEcr = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthenticationBasic> basic = JsonNullable.undefined();

    @JsonProperty("basic")
    public ContainerRegistryAuthenticationBuilder basic(ContainerRegistryAuthenticationBasic value) {
      if (value == null) {
        throw new IllegalStateException("basic cannot be null");
      }
      this.basic = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthenticationDockerHub> dockerHub = JsonNullable.undefined();

    @JsonProperty("docker_hub")
    public ContainerRegistryAuthenticationBuilder dockerHub(ContainerRegistryAuthenticationDockerHub value) {
      if (value == null) {
        throw new IllegalStateException("dockerHub cannot be null");
      }
      this.dockerHub = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthenticationGcpGar> gcpGar = JsonNullable.undefined();

    @JsonProperty("gcp_gar")
    public ContainerRegistryAuthenticationBuilder gcpGar(ContainerRegistryAuthenticationGcpGar value) {
      if (value == null) {
        throw new IllegalStateException("gcpGar cannot be null");
      }
      this.gcpGar = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerRegistryAuthenticationGcpGcr> gcpGcr = JsonNullable.undefined();

    @JsonProperty("gcp_gcr")
    public ContainerRegistryAuthenticationBuilder gcpGcr(ContainerRegistryAuthenticationGcpGcr value) {
      if (value == null) {
        throw new IllegalStateException("gcpGcr cannot be null");
      }
      this.gcpGcr = JsonNullable.of(value);
      return this;
    }
  }
}
