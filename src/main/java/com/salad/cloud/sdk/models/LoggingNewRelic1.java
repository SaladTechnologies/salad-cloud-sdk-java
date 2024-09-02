package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
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
public class LoggingNewRelic1 {

  @NonNull
  @Length(min = 1, max = 1000)
  private String host;

  @NonNull
  @Length(min = 1, max = 1000)
  @JsonProperty("ingestion_key")
  private String ingestionKey;
}
