package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salad.cloud.sdk.validation.annotation.Length;
import com.salad.cloud.sdk.validation.annotation.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an inference endpoint
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class InferenceEndpoint {

  /**
   * The unique identifier
   */
  @NonNull
  private String id;

  /**
   * The inference endpoint name
   */
  @NonNull
  private String name;

  /**
   * The inference endpoint display name
   */
  @NonNull
  @Length(min = 2, max = 63)
  @Pattern("^[ ,-.0-9A-Za-z]+$")
  @JsonProperty("display_name")
  private String displayName;

  /**
   * a brief description of the inference endpoint
   */
  @NonNull
  private String description;

  /**
   * The URL of the inference endpoint
   */
  @NonNull
  @JsonProperty("endpoint_url")
  private String endpointUrl;

  /**
   * A markdown file containing a detailed description of the inference endpoint
   */
  @NonNull
  private String readme;

  /**
   * A description of the price
   */
  @NonNull
  @JsonProperty("price_description")
  private String priceDescription;

  /**
   * The URL of the icon image
   */
  @NonNull
  @JsonProperty("icon_image")
  private String iconImage;
}
