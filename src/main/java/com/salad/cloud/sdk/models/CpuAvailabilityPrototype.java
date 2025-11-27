package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class CpuAvailabilityPrototype {

  /**
   * The number of available CPU cores
   */
  @JsonProperty("cpu")
  private JsonNullable<Long> cpu;

  /**
   * The amount of available memory in MB
   */
  @JsonProperty("memory")
  private JsonNullable<Long> memory;

  /**
   * The amount of available storage in bytes
   */
  @JsonProperty("storage_amount")
  private JsonNullable<Long> storageAmount;

  /**
   * A list of country codes where the resources are available
   */
  @JsonProperty("country_codes")
  private JsonNullable<List<CountryCode>> countryCodes;

  @JsonIgnore
  public Long getCpu() {
    return cpu.orElse(null);
  }

  @JsonIgnore
  public Long getMemory() {
    return memory.orElse(null);
  }

  @JsonIgnore
  public Long getStorageAmount() {
    return storageAmount.orElse(null);
  }

  @JsonIgnore
  public List<CountryCode> getCountryCodes() {
    return countryCodes.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CpuAvailabilityPrototypeBuilder {

    private JsonNullable<Long> cpu = JsonNullable.undefined();

    @JsonProperty("cpu")
    public CpuAvailabilityPrototypeBuilder cpu(Long value) {
      this.cpu = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> memory = JsonNullable.undefined();

    @JsonProperty("memory")
    public CpuAvailabilityPrototypeBuilder memory(Long value) {
      this.memory = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> storageAmount = JsonNullable.undefined();

    @JsonProperty("storage_amount")
    public CpuAvailabilityPrototypeBuilder storageAmount(Long value) {
      this.storageAmount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<CountryCode>> countryCodes = JsonNullable.undefined();

    @JsonProperty("country_codes")
    public CpuAvailabilityPrototypeBuilder countryCodes(List<CountryCode> value) {
      if (value == null) {
        throw new IllegalStateException("countryCodes cannot be null");
      }
      this.countryCodes = JsonNullable.of(value);
      return this;
    }
  }
}
