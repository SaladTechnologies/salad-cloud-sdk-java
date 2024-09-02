package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CreateContainerLogging {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingAxiom2 axiom;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingDatadog2 datadog;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("new_relic")
  private LoggingNewRelic2 newRelic;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingSplunk2 splunk;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingTcp2 tcp;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingHttp2 http;
}
