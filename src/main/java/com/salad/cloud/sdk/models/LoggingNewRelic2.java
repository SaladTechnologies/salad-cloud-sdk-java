package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LoggingNewRelic2 {

  @NonNull
  private String host;

  @NonNull
  @JsonProperty("ingestion_key")
  private String ingestionKey;
}
