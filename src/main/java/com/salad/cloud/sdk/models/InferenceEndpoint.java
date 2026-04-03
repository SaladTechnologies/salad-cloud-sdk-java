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
 * Represents an inference endpoint
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpoint {

  /**
   * The detailed description of the resource.
   */
  @NonNull
  private String description;

  /**
   * The display-friendly name of the resource.
   */
  @NonNull
  @JsonProperty("display_name")
  private String displayName;

  /**
   * The URL of the icon image
   */
  @NonNull
  @JsonProperty("icon_url")
  private String iconUrl;

  /**
   * The inference endpoint identifier.
   */
  @NonNull
  private String id;

  /**
   * The input schema
   */
  @NonNull
  @JsonProperty("input_schema")
  private String inputSchema;

  /**
   * The inference endpoint name.
   */
  @NonNull
  private String name;

  /**
   * The organization name.
   */
  @NonNull
  @JsonProperty("organization_name")
  private String organizationName;

  /**
   * The output schema
   */
  @NonNull
  @JsonProperty("output_schema")
  private String outputSchema;

  /**
   * A description of the price
   */
  @NonNull
  @JsonProperty("price_description")
  private String priceDescription;

  /**
   * A markdown file containing a detailed description of the inference endpoint
   */
  @NonNull
  private String readme;
}
