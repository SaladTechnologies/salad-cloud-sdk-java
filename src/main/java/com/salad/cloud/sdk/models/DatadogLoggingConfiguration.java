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
 * Configuration for forwarding container logs to Datadog monitoring service.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DatadogLoggingConfiguration {

  /**
   * The Datadog intake server host URL where logs will be sent.
   */
  @NonNull
  private String host;

  /**
   * The Datadog API key used for authentication when sending logs.
   */
  @NonNull
  @JsonProperty("api_key")
  private String apiKey;

  /**
   * Optional metadata tags to attach to logs for filtering and categorization in Datadog.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private List<DatadogTagForContainerLogging> tags;

  // Overwrite lombok builder methods
  public static class DatadogLoggingConfigurationBuilder {

    /**
     * Flag to track if the tags property has been set.
     */
    private boolean tags$set = false;

    public DatadogLoggingConfigurationBuilder tags(List<DatadogTagForContainerLogging> tags) {
      this.tags$set = true;
      this.tags = tags;
      return this;
    }

    public DatadogLoggingConfiguration build() {
      if (!tags$set) {
        throw new IllegalStateException("tags is required");
      }
      return new DatadogLoggingConfiguration(host, apiKey, tags);
    }
  }
}
