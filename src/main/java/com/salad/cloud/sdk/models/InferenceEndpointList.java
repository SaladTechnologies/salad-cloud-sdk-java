package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a page from the collection of inference endpoints.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointList {

  /**
   * The list of inference endpoints.
   */
  @NonNull
  private List<InferenceEndpoint> items;

  /**
   * The page number.
   */
  @NonNull
  private Long page;

  /**
   * The maximum number of items per page.
   */
  @NonNull
  @JsonProperty("page_size")
  private Long pageSize;

  /**
   * The total number of items in the collection.
   */
  @NonNull
  @JsonProperty("total_size")
  private Long totalSize;
}
