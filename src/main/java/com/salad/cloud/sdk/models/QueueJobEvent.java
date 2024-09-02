package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an event for queue job
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueJobEvent {

  @NonNull
  private QueueJobEventAction action;

  @NonNull
  private String time;
}
