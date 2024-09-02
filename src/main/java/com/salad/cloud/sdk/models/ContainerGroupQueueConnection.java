package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Max;
import com.salad.cloud.sdk.validation.annotation.Min;
import com.salad.cloud.sdk.validation.annotation.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents container group queue connection
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupQueueConnection {

  @NonNull
  @Length(min = 1, max = 1024)
  private String path;

  @NonNull
  @Max(65535)
  @Min(1)
  private Long port;

  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
  @JsonProperty("queue_name")
  private String queueName;
}
