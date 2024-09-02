package com.salad.cloud.sdk.models;

import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupProbeGrpc {

  @NonNull
  private String service;

  @NonNull
  @Max(65536)
  @Min(0)
  private Long port;
}
