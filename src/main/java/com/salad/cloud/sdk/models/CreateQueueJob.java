package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to create a queue job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateQueueJob {

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object metadata;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String webhook;
}
