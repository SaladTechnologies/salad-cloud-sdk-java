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
public class CpuAvailability {

  /**
   * The number of available CPU cores
   */
  @JsonProperty("available_cpu_batch")
  private JsonNullable<Long> availableCpuBatch;

  /**
   * The amount of on-call CPU
   */
  @JsonProperty("on_call_cpu")
  private JsonNullable<Long> onCallCpu;

  @JsonIgnore
  public Long getAvailableCpuBatch() {
    return availableCpuBatch.orElse(null);
  }

  @JsonIgnore
  public Long getOnCallCpu() {
    return onCallCpu.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CpuAvailabilityBuilder {

    private JsonNullable<Long> availableCpuBatch = JsonNullable.undefined();

    @JsonProperty("available_cpu_batch")
    public CpuAvailabilityBuilder availableCpuBatch(Long value) {
      if (value == null) {
        throw new IllegalStateException("availableCpuBatch cannot be null");
      }
      this.availableCpuBatch = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> onCallCpu = JsonNullable.undefined();

    @JsonProperty("on_call_cpu")
    public CpuAvailabilityBuilder onCallCpu(Long value) {
      if (value == null) {
        throw new IllegalStateException("onCallCpu cannot be null");
      }
      this.onCallCpu = JsonNullable.of(value);
      return this;
    }
  }
}
