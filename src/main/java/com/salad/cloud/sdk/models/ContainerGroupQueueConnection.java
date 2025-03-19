package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Configuration for connecting a container group to a message queue system, enabling asynchronous communication between services.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupQueueConnection {

  /**
   * The endpoint path for accessing the queue service, relative to the base URL of the queue server.
   */
  @NonNull
  private String path;

  /**
   * The network port number used to connect to the queue service. Must be a valid TCP/IP port between 1 and 65535.
   */
  @NonNull
  private Long port;

  /**
   * Unique identifier for the queue. Must start with a lowercase letter, can contain lowercase letters, numbers, and hyphens, and must end with a letter or number.
   */
  @NonNull
  @JsonProperty("queue_name")
  private String queueName;
}
