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
public class UpdateContainerLogging {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingAxiom3 axiom;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingDatadog3 datadog;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("new_relic")
  private LoggingNewRelic3 newRelic;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingSplunk3 splunk;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingTcp3 tcp;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private LoggingHttp3 http;
}
