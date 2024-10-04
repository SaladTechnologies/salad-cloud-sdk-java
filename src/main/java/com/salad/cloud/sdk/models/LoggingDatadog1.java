package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class LoggingDatadog1 {

  @NonNull
  private String host;

  @NonNull
  @JsonProperty("api_key")
  private String apiKey;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<DatadogTags1> tags;
}
