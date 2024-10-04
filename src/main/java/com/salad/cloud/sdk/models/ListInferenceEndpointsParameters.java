package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ListInferenceEndpointsParameters {

  /**
   * The page number
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long page;

  /**
   * The number of items per page
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("page_size")
  private Long pageSize;
}
