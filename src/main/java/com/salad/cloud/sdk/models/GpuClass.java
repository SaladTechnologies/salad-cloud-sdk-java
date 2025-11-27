package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Represents a GPU Class
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class GpuClass {

  /**
   * The unique identifier
   */
  @NonNull
  private String id;

  /**
   * The GPU class name
   */
  @NonNull
  private String name;

  /**
   * The list of prices for each container group priority
   */
  @NonNull
  private List<GpuClassPrice> prices;

  /**
   * Whether the GPU class is in high demand
   */
  @JsonProperty("is_high_demand")
  private JsonNullable<Boolean> isHighDemand;

  /**
   * The type of GPU class
   */
  @JsonProperty("gpu_class_type")
  private JsonNullable<GpuClassType> gpuClassType;

  /**
   * The number of GPUs in the cluster
   */
  @JsonProperty("gpu_count")
  private JsonNullable<Long> gpuCount;

  /**
   * The minimum vCPU count
   */
  @JsonProperty("min_vcpu")
  private JsonNullable<Long> minVcpu;

  /**
   * The maximum vCPU count
   */
  @JsonProperty("max_vcpu")
  private JsonNullable<Long> maxVcpu;

  /**
   * The minimum RAM amount in MB
   */
  @JsonProperty("min_ram")
  private JsonNullable<Long> minRam;

  /**
   * The maximum RAM amount in MB
   */
  @JsonProperty("max_ram")
  private JsonNullable<Long> maxRam;

  /**
   * The minimum storage amount in bytes
   */
  @JsonProperty("min_storage")
  private JsonNullable<Long> minStorage;

  /**
   * The maximum storage amount in bytes
   */
  @JsonProperty("max_storage")
  private JsonNullable<Long> maxStorage;

  @JsonIgnore
  public Boolean getIsHighDemand() {
    return isHighDemand.orElse(null);
  }

  @JsonIgnore
  public GpuClassType getGpuClassType() {
    return gpuClassType.orElse(null);
  }

  @JsonIgnore
  public Long getGpuCount() {
    return gpuCount.orElse(null);
  }

  @JsonIgnore
  public Long getMinVcpu() {
    return minVcpu.orElse(null);
  }

  @JsonIgnore
  public Long getMaxVcpu() {
    return maxVcpu.orElse(null);
  }

  @JsonIgnore
  public Long getMinRam() {
    return minRam.orElse(null);
  }

  @JsonIgnore
  public Long getMaxRam() {
    return maxRam.orElse(null);
  }

  @JsonIgnore
  public Long getMinStorage() {
    return minStorage.orElse(null);
  }

  @JsonIgnore
  public Long getMaxStorage() {
    return maxStorage.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GpuClassBuilder {

    private JsonNullable<Boolean> isHighDemand = JsonNullable.undefined();

    @JsonProperty("is_high_demand")
    public GpuClassBuilder isHighDemand(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("isHighDemand cannot be null");
      }
      this.isHighDemand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<GpuClassType> gpuClassType = JsonNullable.undefined();

    @JsonProperty("gpu_class_type")
    public GpuClassBuilder gpuClassType(GpuClassType value) {
      if (value == null) {
        throw new IllegalStateException("gpuClassType cannot be null");
      }
      this.gpuClassType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> gpuCount = JsonNullable.undefined();

    @JsonProperty("gpu_count")
    public GpuClassBuilder gpuCount(Long value) {
      if (value == null) {
        throw new IllegalStateException("gpuCount cannot be null");
      }
      this.gpuCount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> minVcpu = JsonNullable.undefined();

    @JsonProperty("min_vcpu")
    public GpuClassBuilder minVcpu(Long value) {
      if (value == null) {
        throw new IllegalStateException("minVcpu cannot be null");
      }
      this.minVcpu = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxVcpu = JsonNullable.undefined();

    @JsonProperty("max_vcpu")
    public GpuClassBuilder maxVcpu(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxVcpu cannot be null");
      }
      this.maxVcpu = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> minRam = JsonNullable.undefined();

    @JsonProperty("min_ram")
    public GpuClassBuilder minRam(Long value) {
      if (value == null) {
        throw new IllegalStateException("minRam cannot be null");
      }
      this.minRam = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxRam = JsonNullable.undefined();

    @JsonProperty("max_ram")
    public GpuClassBuilder maxRam(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxRam cannot be null");
      }
      this.maxRam = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> minStorage = JsonNullable.undefined();

    @JsonProperty("min_storage")
    public GpuClassBuilder minStorage(Long value) {
      if (value == null) {
        throw new IllegalStateException("minStorage cannot be null");
      }
      this.minStorage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxStorage = JsonNullable.undefined();

    @JsonProperty("max_storage")
    public GpuClassBuilder maxStorage(Long value) {
      if (value == null) {
        throw new IllegalStateException("maxStorage cannot be null");
      }
      this.maxStorage = JsonNullable.of(value);
      return this;
    }
  }
}
