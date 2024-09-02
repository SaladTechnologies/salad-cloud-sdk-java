package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Min;
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
public class ContainerGroupsQuotas {

  @NonNull
  @JsonProperty("max_created_container_groups")
  private Long maxCreatedContainerGroups;

  @NonNull
  @JsonProperty("container_instance_quota")
  private Long containerInstanceQuota;

  @Min(0)
  @Builder.Default
  @JsonProperty("max_container_group_reallocations_per_minute")
  private Long maxContainerGroupReallocationsPerMinute = 10L;

  @Min(0)
  @Builder.Default
  @JsonProperty("max_container_group_recreates_per_minute")
  private Long maxContainerGroupRecreatesPerMinute = 10L;

  @Min(0)
  @Builder.Default
  @JsonProperty("max_container_group_restarts_per_minute")
  private Long maxContainerGroupRestartsPerMinute = 10L;
}
