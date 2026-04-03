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
public class GpuAvailability {

  /**
   * The number of available GPU batches
   */
  @JsonProperty("available_gpu_batch")
  private JsonNullable<Long> availableGpuBatch;

  /**
   * The number of available high-end GPUs
   */
  @JsonProperty("available_gpu_high")
  private JsonNullable<Long> availableGpuHigh;

  /**
   * The number of available low-end GPUs
   */
  @JsonProperty("available_gpu_low")
  private JsonNullable<Long> availableGpuLow;

  /**
   * The number of available medium-end GPUs
   */
  @JsonProperty("available_gpu_medium")
  private JsonNullable<Long> availableGpuMedium;

  /**
   * The number of on-call GPUs available
   */
  @JsonProperty("on_call_gpu")
  private JsonNullable<Long> onCallGpu;

  @JsonIgnore
  public Long getAvailableGpuBatch() {
    return availableGpuBatch.orElse(null);
  }

  @JsonIgnore
  public Long getAvailableGpuHigh() {
    return availableGpuHigh.orElse(null);
  }

  @JsonIgnore
  public Long getAvailableGpuLow() {
    return availableGpuLow.orElse(null);
  }

  @JsonIgnore
  public Long getAvailableGpuMedium() {
    return availableGpuMedium.orElse(null);
  }

  @JsonIgnore
  public Long getOnCallGpu() {
    return onCallGpu.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GpuAvailabilityBuilder {

    private JsonNullable<Long> availableGpuBatch = JsonNullable.undefined();

    @JsonProperty("available_gpu_batch")
    public GpuAvailabilityBuilder availableGpuBatch(Long value) {
      if (value == null) {
        throw new IllegalStateException("availableGpuBatch cannot be null");
      }
      this.availableGpuBatch = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> availableGpuHigh = JsonNullable.undefined();

    @JsonProperty("available_gpu_high")
    public GpuAvailabilityBuilder availableGpuHigh(Long value) {
      if (value == null) {
        throw new IllegalStateException("availableGpuHigh cannot be null");
      }
      this.availableGpuHigh = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> availableGpuLow = JsonNullable.undefined();

    @JsonProperty("available_gpu_low")
    public GpuAvailabilityBuilder availableGpuLow(Long value) {
      if (value == null) {
        throw new IllegalStateException("availableGpuLow cannot be null");
      }
      this.availableGpuLow = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> availableGpuMedium = JsonNullable.undefined();

    @JsonProperty("available_gpu_medium")
    public GpuAvailabilityBuilder availableGpuMedium(Long value) {
      if (value == null) {
        throw new IllegalStateException("availableGpuMedium cannot be null");
      }
      this.availableGpuMedium = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> onCallGpu = JsonNullable.undefined();

    @JsonProperty("on_call_gpu")
    public GpuAvailabilityBuilder onCallGpu(Long value) {
      if (value == null) {
        throw new IllegalStateException("onCallGpu cannot be null");
      }
      this.onCallGpu = JsonNullable.of(value);
      return this;
    }
  }
}
