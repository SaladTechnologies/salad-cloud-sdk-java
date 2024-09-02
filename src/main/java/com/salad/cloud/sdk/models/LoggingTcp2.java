package com.salad.cloud.sdk.models;

import com.salad.cloud.sdk.validation.annotation.Length;
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
public class LoggingTcp2 {

  @NonNull
  @Length(min = 1, max = 1000)
  private String host;

  @NonNull
  @Max(65535)
  @Min(1)
  private Long port;
}
