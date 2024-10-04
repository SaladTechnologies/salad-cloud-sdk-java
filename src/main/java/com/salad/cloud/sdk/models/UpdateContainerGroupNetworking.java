package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents update container group networking parameters
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateContainerGroupNetworking {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Long port;
}
