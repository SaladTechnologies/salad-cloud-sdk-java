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
 * Represents a request to create a new queue.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueuePrototype {

  /**
   * The queue name. This must be unique within the project.
   */
  @NonNull
  private String name;

  /**
   * The description. This may be used as a space for notes or other information about the queue.
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * The display name. This may be used as a more human-readable name.
   */
  @JsonProperty("display_name")
  private JsonNullable<String> displayName;

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class QueuePrototypeBuilder {

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public QueuePrototypeBuilder description(String value) {
      if (value == null) {
        throw new IllegalStateException("description cannot be null");
      }
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> displayName = JsonNullable.undefined();

    @JsonProperty("display_name")
    public QueuePrototypeBuilder displayName(String value) {
      if (value == null) {
        throw new IllegalStateException("displayName cannot be null");
      }
      this.displayName = JsonNullable.of(value);
      return this;
    }
  }
}
