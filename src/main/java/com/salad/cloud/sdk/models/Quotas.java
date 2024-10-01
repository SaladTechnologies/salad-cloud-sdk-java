package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the organization quotas
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class Quotas {

  @NonNull
  @JsonProperty("container_groups_quotas")
  private ContainerGroupsQuotas containerGroupsQuotas;

  /**
   * The time the resource was created
   */
  @JsonProperty("create_time")
  private String createTime;

  /**
   * The time the resource was last updated
   */
  @JsonProperty("update_time")
  private String updateTime;
}
