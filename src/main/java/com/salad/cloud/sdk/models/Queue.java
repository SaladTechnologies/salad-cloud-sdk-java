package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Pattern;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a queue.
 */
@Data
@Builder
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
  @Length(min = 2, max = 63)
  @Pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
  private String name;

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
  @JsonProperty("display_name")
  private String displayName;

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
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Length(max = 500)
  private String description;
}
