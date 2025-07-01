package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

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
  private JsonNullable<Long> maxContainerGroupReallocationsPerMinute;

  /**
   * The maximum number of container group recreates per minute
   */
  @JsonProperty("max_container_group_recreates_per_minute")
  private JsonNullable<Long> maxContainerGroupRecreatesPerMinute;

  /**
   * The maximum number of container group restarts per minute
   */
  @JsonProperty("max_container_group_restarts_per_minute")
  private JsonNullable<Long> maxContainerGroupRestartsPerMinute;

  @JsonIgnore
  public Long getMaxContainerGroupReallocationsPerMinute() {
    return maxContainerGroupReallocationsPerMinute.orElse(null);
  }

  @JsonIgnore
  public Long getMaxContainerGroupRecreatesPerMinute() {
    return maxContainerGroupRecreatesPerMinute.orElse(null);
  }

  @JsonIgnore
  public Long getMaxContainerGroupRestartsPerMinute() {
    return maxContainerGroupRestartsPerMinute.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupsQuotasBuilder {

    private JsonNullable<Long> maxContainerGroupReallocationsPerMinute = JsonNullable.undefined();

    @JsonProperty("max_container_group_reallocations_per_minute")
    public ContainerGroupsQuotasBuilder maxContainerGroupReallocationsPerMinute(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxContainerGroupReallocationsPerMinute cannot be null");
      }
      this.maxContainerGroupReallocationsPerMinute = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxContainerGroupRecreatesPerMinute = JsonNullable.undefined();

    @JsonProperty("max_container_group_recreates_per_minute")
    public ContainerGroupsQuotasBuilder maxContainerGroupRecreatesPerMinute(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxContainerGroupRecreatesPerMinute cannot be null");
      }
      this.maxContainerGroupRecreatesPerMinute = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxContainerGroupRestartsPerMinute = JsonNullable.undefined();

    @JsonProperty("max_container_group_restarts_per_minute")
    public ContainerGroupsQuotasBuilder maxContainerGroupRestartsPerMinute(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxContainerGroupRestartsPerMinute cannot be null");
      }
      this.maxContainerGroupRestartsPerMinute = JsonNullable.of(value);
      return this;
    }
  }
}
