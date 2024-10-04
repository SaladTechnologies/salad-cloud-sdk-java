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
 * Represents container group queue connection
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupQueueConnection {

  @NonNull
  private String path;

  @NonNull
  private Long port;

  @NonNull
  @JsonProperty("queue_name")
  private String queueName;
}
