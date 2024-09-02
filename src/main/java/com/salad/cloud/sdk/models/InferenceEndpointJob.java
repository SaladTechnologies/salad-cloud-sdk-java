package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a inference endpoint job
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJob {

  @NonNull
  private String id;

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * The inference endpoint name
   */
  @NonNull
  @JsonProperty("inference_endpoint_name")
  private String inferenceEndpointName;

  @NonNull
  private InferenceEndpointJobStatus status;

  @NonNull
  private List<InferenceEndpointJobEvent> events;

  /**
   * The organization name
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object metadata;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String webhook;

  /**
   * The job output. May be any valid JSON.
   */
  private Object output;
}
