package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ListQueueJobsParameters {

  /**
   * The page number.
   */
  @JsonProperty("page")
  private JsonNullable<Long> page;

  /**
   * The maximum number of items per page.
   */
  @JsonProperty("page_size")
  private JsonNullable<Long> pageSize;

  @JsonIgnore
  public Long getPage() {
    return page.orElse(null);
  }

  @JsonIgnore
  public Long getPageSize() {
    return pageSize.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListQueueJobsParametersBuilder {

    private JsonNullable<Long> page = JsonNullable.undefined();

    @JsonProperty("page")
    public ListQueueJobsParametersBuilder page(Long value) {
      if (value == null) {
        throw new IllegalStateException("page cannot be null");
      }
      this.page = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> pageSize = JsonNullable.undefined();

    @JsonProperty("page_size")
    public ListQueueJobsParametersBuilder pageSize(Long value) {
      if (value == null) {
        throw new IllegalStateException("pageSize cannot be null");
      }
      this.pageSize = JsonNullable.of(value);
      return this;
    }
  }
}
