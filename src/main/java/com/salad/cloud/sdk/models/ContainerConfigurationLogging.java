package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Configuration options for directing container logs to a logging provider. This schema enables you to specify a single logging destination for container output, supporting monitoring, debugging, and analytics use cases. Each provider has its own configuration parameters defined in the referenced schemas. Only one logging provider can be selected at a time.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerConfigurationLogging {

  /**
   * Configuration settings for integrating container logs with the Axiom logging service. When specified, container logs will be forwarded to the Axiom instance defined by these parameters.
   */
  @JsonProperty("axiom")
  private JsonNullable<AxiomLoggingConfiguration> axiom;

  /**
   * Configuration for forwarding container logs to Datadog monitoring service.
   */
  @JsonProperty("datadog")
  private JsonNullable<DatadogLoggingConfiguration> datadog;

  /**
   * Configuration for sending container logs to an HTTP endpoint. Defines how logs are formatted, compressed, and transmitted.
   */
  @JsonProperty("http")
  private JsonNullable<ContainerLoggingConfigurationHttp2> http;

  /**
   * Configuration for sending container logs to New Relic's log management platform.
   */
  @JsonProperty("new_relic")
  private JsonNullable<NewRelicLoggingConfiguration> newRelic;

  /**
   * Configuration settings for forwarding container logs to a Splunk instance.
   */
  @JsonProperty("splunk")
  private JsonNullable<ContainerLoggingSplunkConfiguration> splunk;

  /**
   * Configuration for forwarding container logs to a remote TCP endpoint
   */
  @JsonProperty("tcp")
  private JsonNullable<TcpLoggingConfiguration> tcp;

  @JsonIgnore
  public AxiomLoggingConfiguration getAxiom() {
    return axiom.orElse(null);
  }

  @JsonIgnore
  public DatadogLoggingConfiguration getDatadog() {
    return datadog.orElse(null);
  }

  @JsonIgnore
  public ContainerLoggingConfigurationHttp2 getHttp() {
    return http.orElse(null);
  }

  @JsonIgnore
  public NewRelicLoggingConfiguration getNewRelic() {
    return newRelic.orElse(null);
  }

  @JsonIgnore
  public ContainerLoggingSplunkConfiguration getSplunk() {
    return splunk.orElse(null);
  }

  @JsonIgnore
  public TcpLoggingConfiguration getTcp() {
    return tcp.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerConfigurationLoggingBuilder {

    private JsonNullable<AxiomLoggingConfiguration> axiom = JsonNullable.undefined();

    @JsonProperty("axiom")
    public ContainerConfigurationLoggingBuilder axiom(AxiomLoggingConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("axiom cannot be null");
      }
      this.axiom = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<DatadogLoggingConfiguration> datadog = JsonNullable.undefined();

    @JsonProperty("datadog")
    public ContainerConfigurationLoggingBuilder datadog(DatadogLoggingConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("datadog cannot be null");
      }
      this.datadog = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerLoggingConfigurationHttp2> http = JsonNullable.undefined();

    @JsonProperty("http")
    public ContainerConfigurationLoggingBuilder http(ContainerLoggingConfigurationHttp2 value) {
      if (value == null) {
        throw new IllegalStateException("http cannot be null");
      }
      this.http = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<NewRelicLoggingConfiguration> newRelic = JsonNullable.undefined();

    @JsonProperty("new_relic")
    public ContainerConfigurationLoggingBuilder newRelic(NewRelicLoggingConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("newRelic cannot be null");
      }
      this.newRelic = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ContainerLoggingSplunkConfiguration> splunk = JsonNullable.undefined();

    @JsonProperty("splunk")
    public ContainerConfigurationLoggingBuilder splunk(ContainerLoggingSplunkConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("splunk cannot be null");
      }
      this.splunk = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TcpLoggingConfiguration> tcp = JsonNullable.undefined();

    @JsonProperty("tcp")
    public ContainerConfigurationLoggingBuilder tcp(TcpLoggingConfiguration value) {
      if (value == null) {
        throw new IllegalStateException("tcp cannot be null");
      }
      this.tcp = JsonNullable.of(value);
      return this;
    }
  }
}
