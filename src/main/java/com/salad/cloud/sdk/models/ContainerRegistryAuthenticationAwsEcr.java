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
 * Authentication details for AWS Elastic Container Registry (ECR)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerRegistryAuthenticationAwsEcr {

  /**
   * AWS access key ID used for ECR authentication
   */
  @NonNull
  @JsonProperty("access_key_id")
  private String accessKeyId;

  /**
   * AWS secret access key used for ECR authentication
   */
  @NonNull
  @JsonProperty("secret_access_key")
  private String secretAccessKey;
}
