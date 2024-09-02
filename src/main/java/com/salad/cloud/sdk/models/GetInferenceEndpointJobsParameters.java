package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class GetInferenceEndpointJobsParameters {

  /**
   * The page number
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Max(2147483647)
  @Min(1)
  private Long page;

  /**
   * The number of items per page
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Max(100)
  @Min(1)
  @JsonProperty("page_size")
  private Long pageSize;
}
