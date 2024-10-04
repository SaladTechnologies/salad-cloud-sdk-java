package com.salad.cloud.sdk.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a list of queues
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class QueueList {

  /**
   * The list of queues.
   */
  @NonNull
  private List<Queue> items;
}
