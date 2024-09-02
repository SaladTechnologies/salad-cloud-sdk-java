package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents update container group networking parameters
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerGroupNetworking {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Max(65535)
  @Min(1)
  private Long port;
}
