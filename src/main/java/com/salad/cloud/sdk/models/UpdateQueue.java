package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to update an existing queue.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateQueue {

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("display_name")
  private String displayName;

  /**
   * The description. This may be used as a space for notes or other information about the queue.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String description;
}
