package com.salad.cloud.sdk.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a list of inference endpoints
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointsList {

  /**
   * The list of items
   */
  @NonNull
  private List<InferenceEndpoint> items;
}
