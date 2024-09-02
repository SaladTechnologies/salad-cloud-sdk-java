package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to update an existing queue.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateQueue {

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
  @JsonProperty("display_name")
  private String displayName;

  /**
   * The description. This may be used as a space for notes or other information about the queue.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Length(max = 500)
  private String description;
}
