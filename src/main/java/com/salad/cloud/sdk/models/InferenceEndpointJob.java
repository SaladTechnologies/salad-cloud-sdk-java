package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a inference endpoint job
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpointJob {

  /**
   * The unique identifier.
   */
  @NonNull
  private String id;

  /**
   * The job input. May be any valid JSON.
   */
  @NonNull
  private Object input;

  /**
   * The inference endpoint name.
   */
  @NonNull
  @JsonProperty("inference_endpoint_name")
  private String inferenceEndpointName;

  /**
   * The current status.
   */
  @NonNull
  private InferenceEndpointJobStatus status;

  /**
   * The list of events.
   */
  @NonNull
  private List<InferenceEndpointJobEvent> events;

  /**
   * The organization name.
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  /**
   * The time the job was created.
   */
  @NonNull
  @JsonProperty("create_time")
  private String createTime;

  /**
   * The time the job was last updated.
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The job metadata. May be any valid JSON.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object metadata;

  /**
   * The webhook URL called when the job completes.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String webhook;

  /**
   * The job output. May be any valid JSON.
   */
  private Object output;
}
