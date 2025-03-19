package com.salad.cloud.sdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Configuration settings for forwarding container logs to a Splunk instance.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerLoggingSplunkConfiguration {

  /**
   * The URL of the Splunk HTTP Event Collector (HEC) endpoint.
   */
  @NonNull
  private String host;

  /**
   * The authentication token required to send data to the Splunk HEC endpoint.
   */
  @NonNull
  private String token;
}
