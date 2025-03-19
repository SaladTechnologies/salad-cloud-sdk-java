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
 * Authentication details for Google Container Registry (GCR)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerRegistryAuthenticationGcpGcr {

  /**
   * GCP service account key in JSON format for GCR authentication
   */
  @NonNull
  @JsonProperty("service_key")
  private String serviceKey;
}
