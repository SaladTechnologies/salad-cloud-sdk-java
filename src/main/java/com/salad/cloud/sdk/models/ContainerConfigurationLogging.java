package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private AxiomLoggingConfiguration axiom;

  /**
   * Configuration for forwarding container logs to Datadog monitoring service.
   */
  private DatadogLoggingConfiguration datadog;

  /**
   * Configuration for sending container logs to an HTTP endpoint. Defines how logs are formatted, compressed, and transmitted.
   */
  private ContainerLoggingConfigurationHttp2 http;

  /**
   * Configuration for sending container logs to New Relic's log management platform.
   */
  @JsonProperty("new_relic")
  private NewRelicLoggingConfiguration newRelic;

  /**
   * Configuration settings for forwarding container logs to a Splunk instance.
   */
  private ContainerLoggingSplunkConfiguration splunk;

  /**
   * Configuration for forwarding container logs to a remote TCP endpoint
   */
  private TcpLoggingConfiguration tcp;
}
