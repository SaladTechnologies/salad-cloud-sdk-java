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
 * Represents the organization quotas
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Quotas {

  /**
   * Represents the organization quotas for container groups
   */
  @NonNull
  @JsonProperty("container_groups_quotas")
  private ContainerGroupsQuotas containerGroupsQuotas;

  /**
   * The time the resource was created
   */
  @JsonProperty("create_time")
  private JsonNullable<String> createTime;

  /**
   * The time the resource was last updated
   */
  @JsonProperty("update_time")
  private JsonNullable<String> updateTime;

  @JsonIgnore
  public String getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonIgnore
  public String getUpdateTime() {
    return updateTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QuotasBuilder {

    private JsonNullable<String> createTime = JsonNullable.undefined();

    @JsonProperty("create_time")
    public QuotasBuilder createTime(String value) {
      if (value == null) {
        throw new IllegalStateException("createTime cannot be null");
      }
      this.createTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> updateTime = JsonNullable.undefined();

    @JsonProperty("update_time")
    public QuotasBuilder updateTime(String value) {
      if (value == null) {
        throw new IllegalStateException("updateTime cannot be null");
      }
      this.updateTime = JsonNullable.of(value);
      return this;
    }
  }
}
