package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
   * The maximum number of container groups that can be created
   */
  @JsonProperty("max_created_container_groups")
  private Long maxCreatedContainerGroups;

  /**
   * The maximum number of replicas that can be created for a container group
   */
  @JsonProperty("container_instance_quota")
  private Long containerInstanceQuota;

  /**
   * The maximum number of replicas that can be created for a container group
   */
  @JsonProperty("container_replica_quota")
  private Long containerReplicaQuota;

  /**
   * The number of replicas that are currently in use
   */
  @JsonProperty("container_replicas_used")
  private Long containerReplicasUsed;

  /**
   * The maximum number of container group reallocations per minute
   */
  @Builder.Default
  @JsonProperty("max_container_group_reallocations_per_minute")
  private Long maxContainerGroupReallocationsPerMinute = 10L;

  /**
   * The maximum number of container group recreates per minute
   */
  @Builder.Default
  @JsonProperty("max_container_group_recreates_per_minute")
  private Long maxContainerGroupRecreatesPerMinute = 10L;

  /**
   * The maximum number of container group restarts per minute
   */
  @Builder.Default
  @JsonProperty("max_container_group_restarts_per_minute")
  private Long maxContainerGroupRestartsPerMinute = 10L;
}
