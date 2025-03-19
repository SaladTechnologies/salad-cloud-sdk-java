package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an event for inference endpoint job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJobEvent {

  /**
   * The action that was taken on the inference endpoint job.
   */
  @NonNull
  private InferenceEndpointJobEventAction action;

  /**
   * The time the event occurred.
   */
  @NonNull
  private String time;
}
