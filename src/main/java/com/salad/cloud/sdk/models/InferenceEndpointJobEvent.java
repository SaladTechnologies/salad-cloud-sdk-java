package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an event for inference endpoint job
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJobEvent {

  @NonNull
  private InferenceEndpointJobEventAction action;

  @NonNull
  private String time;
}
