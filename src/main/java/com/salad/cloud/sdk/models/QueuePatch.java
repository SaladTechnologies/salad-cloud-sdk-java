package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a request to update an existing queue.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueuePatch {

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @JsonProperty("display_name")
  private JsonNullable<String> displayName;

  /**
   * The description. This may be used as a space for notes or other information about the queue.
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QueuePatchBuilder {

    private JsonNullable<String> displayName = JsonNullable.undefined();

    @JsonProperty("display_name")
    public QueuePatchBuilder displayName(String value) {
      this.displayName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public QueuePatchBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }
  }
}
