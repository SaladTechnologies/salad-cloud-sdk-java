package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
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
public class LoggingDatadog3 {

  @NonNull
  @Length(min = 1, max = 1000)
  private String host;

  @NonNull
  @Length(min = 1, max = 1000)
  @JsonProperty("api_key")
  private String apiKey;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<DatadogTags3> tags;
}
