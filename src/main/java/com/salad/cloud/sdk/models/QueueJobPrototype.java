package com.salad.cloud.sdk.models;

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
public class QueueJobPrototype {

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * Additional metadata for the job
   */
  private Object metadata;

  /**
   * The webhook to call when the job completes
   */
  private String webhook;
}
