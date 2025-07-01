package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a queue.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Queue {

  /**
   * The queue identifier. This is automatically generated and assigned when the queue is created.
   */
  @NonNull
  private String id;

  /**
   * The queue name. This must be unique within the project.
   */
  @NonNull
  private String name;

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @NonNull
  @JsonProperty("display_name")
  private String displayName;

  /**
   * The container groups that are part of this queue. Each container group represents a scalable set of identical containers running as a distributed service.
   */
  @NonNull
  @JsonProperty("container_groups")
  private List<ContainerGroup> containerGroups;

  /**
   * The date and time the queue was created.
   */
  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  /**
   * The date and time the queue was last updated.
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The description. This may be used as a space for notes or other information about the queue.
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QueueBuilder {

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public QueueBuilder description(String value) {
      if (value == null) {
        throw new IllegalStateException("description cannot be null");
      }
      this.description = JsonNullable.of(value);
      return this;
    }
  }
}
