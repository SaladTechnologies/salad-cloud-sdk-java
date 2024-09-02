package com.salad.cloud.sdk.models;

import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import java.util.List;
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
public class ContainerGroupProbeHttp {

  @NonNull
  private String path;

  @NonNull
  @Max(65536)
  @Min(0)
  private Long port;

  private ContainerProbeHttpScheme scheme;

  private List<ContainerGroupProbeHttpHeaders2> headers;
}
