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
 * Represents the organization quotas for container groups
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupsQuotas {

  /**
   * The maximum number of replicas that can be created for a container group
   */
  @NonNull
  @JsonProperty("container_replicas_quota")
  private Long containerReplicasQuota;

  /**
   * The number of replicas that are currently in use
   */
  @NonNull
  @JsonProperty("container_replicas_used")
  private Long containerReplicasUsed;

  /**
   * The maximum number of container group reallocations per minute
   */
  @JsonProperty("max_container_group_reallocations_per_minute")
  private Long maxContainerGroupReallocationsPerMinute;

  /**
   * The maximum number of container group recreates per minute
   */
  @JsonProperty("max_container_group_recreates_per_minute")
  private Long maxContainerGroupRecreatesPerMinute;

  /**
   * The maximum number of container group restarts per minute
   */
  @JsonProperty("max_container_group_restarts_per_minute")
  private Long maxContainerGroupRestartsPerMinute;
}
