package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an event for queue job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueJobEvent {

  /**
   * The action that was taken on the queue job
   */
  @NonNull
  private Action action;

  /**
   * The time the action was taken on the queue job
   */
  @NonNull
  private String time;
}
