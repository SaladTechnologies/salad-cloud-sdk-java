package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerLogging {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingAxiom1 axiom;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingDatadog1 datadog;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("new_relic")
  private LoggingNewRelic1 newRelic;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingSplunk1 splunk;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingTcp1 tcp;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingHttp1 http;
}
