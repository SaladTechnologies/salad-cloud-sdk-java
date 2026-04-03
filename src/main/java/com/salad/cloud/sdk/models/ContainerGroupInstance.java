package com.salad.cloud.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A Container Group Instance represents a running instance of a container group on a specific machine. It provides information about the execution state, readiness, and version of the deployed container group.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerGroupInstance {

  /**
   * The container group instance identifier.
   */
  @NonNull
  private String id;

  /**
   * The container group machine identifier.
   */
  @NonNull
  @JsonProperty("machine_id")
  private String machineId;

  /**
   * The state of the container group instance
   */
  @NonNull
  private TheContainerGroupInstanceState state;

  /**
   * The UTC timestamp when the container group instance last changed its state. This helps track the lifecycle and state transitions of the instance.
   */
  @NonNull
  @JsonProperty("update_time")
  private String updateTime;

  /**
   * The version of the container group definition currently running on this instance. Used to track deployment and update progress across the container group fleet.
   */
  @NonNull
  private Long version;

  /**
   * The percentage of CPU used by this container group instance. This is updated every minute.
   */
  @JsonProperty("cpu_percent")
  private JsonNullable<Double> cpuPercent;

  /**
   * The total CPU usage in seconds for this container group instance. This is updated every minute.
   */
  @JsonProperty("cpu_usage")
  private JsonNullable<Long> cpuUsage;

  /**
   * The total CPU usage in seconds for this container group instance since it was started. This is updated every minute.
   */
  @JsonProperty("cpu_usage_total")
  private JsonNullable<Long> cpuUsageTotal;

  /**
   * The cost of deleting the container group instance
   */
  @JsonProperty("deletion_cost")
  private JsonNullable<Long> deletionCost;

  /**
   * The memory usage in MB for this container group instance. This is updated every minute.
   */
  @JsonProperty("memory_usage_mb")
  private JsonNullable<Double> memoryUsageMb;

  /**
   * The percentage of memory used by this container group instance. This is updated every minute.
   */
  @JsonProperty("memory_usage_percent")
  private JsonNullable<Double> memoryUsagePercent;

  /**
   * The progress percentage of pulling the container image. This is only relevant when the instance state is 'downloading'.
   */
  @JsonProperty("pulling_progress")
  private JsonNullable<Double> pullingProgress;

  /**
   * Indicates whether the container group instance is currently passing its readiness checks and is able to receive traffic or perform its intended function. If no readiness probe is defined, this will be true once the instance is fully started.
   */
  @JsonProperty("ready")
  private JsonNullable<Boolean> ready;

  /**
   * The SSH host key fingerprint of the container group instance
   */
  @JsonProperty("ssh_host_key_fingerprint")
  private JsonNullable<String> sshHostKeyFingerprint;

  /**
   * The SSH IP address of the container group instance
   */
  @JsonProperty("ssh_ip")
  private JsonNullable<String> sshIp;

  /**
   * The SSH port of the container group instance
   */
  @JsonProperty("ssh_port")
  private JsonNullable<Long> sshPort;

  /**
   * Indicates whether the container group instance has successfully completed its startup sequence and passed any configured startup probes. This will always be true when no startup probe is defined for the container group.
   */
  @JsonProperty("started")
  private JsonNullable<Boolean> started;

  @JsonIgnore
  public Double getCpuPercent() {
    return cpuPercent.orElse(null);
  }

  @JsonIgnore
  public Long getCpuUsage() {
    return cpuUsage.orElse(null);
  }

  @JsonIgnore
  public Long getCpuUsageTotal() {
    return cpuUsageTotal.orElse(null);
  }

  @JsonIgnore
  public Long getDeletionCost() {
    return deletionCost.orElse(null);
  }

  @JsonIgnore
  public Double getMemoryUsageMb() {
    return memoryUsageMb.orElse(null);
  }

  @JsonIgnore
  public Double getMemoryUsagePercent() {
    return memoryUsagePercent.orElse(null);
  }

  @JsonIgnore
  public Double getPullingProgress() {
    return pullingProgress.orElse(null);
  }

  @JsonIgnore
  public Boolean getReady() {
    return ready.orElse(null);
  }

  @JsonIgnore
  public String getSshHostKeyFingerprint() {
    return sshHostKeyFingerprint.orElse(null);
  }

  @JsonIgnore
  public String getSshIp() {
    return sshIp.orElse(null);
  }

  @JsonIgnore
  public Long getSshPort() {
    return sshPort.orElse(null);
  }

  @JsonIgnore
  public Boolean getStarted() {
    return started.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ContainerGroupInstanceBuilder {

    private JsonNullable<Double> cpuPercent = JsonNullable.undefined();

    @JsonProperty("cpu_percent")
    public ContainerGroupInstanceBuilder cpuPercent(Double value) {
      if (value == null) {
        throw new IllegalStateException("cpuPercent cannot be null");
      }
      this.cpuPercent = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> cpuUsage = JsonNullable.undefined();

    @JsonProperty("cpu_usage")
    public ContainerGroupInstanceBuilder cpuUsage(Long value) {
      if (value == null) {
        throw new IllegalStateException("cpuUsage cannot be null");
      }
      this.cpuUsage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> cpuUsageTotal = JsonNullable.undefined();

    @JsonProperty("cpu_usage_total")
    public ContainerGroupInstanceBuilder cpuUsageTotal(Long value) {
      if (value == null) {
        throw new IllegalStateException("cpuUsageTotal cannot be null");
      }
      this.cpuUsageTotal = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> deletionCost = JsonNullable.undefined();

    @JsonProperty("deletion_cost")
    public ContainerGroupInstanceBuilder deletionCost(Long value) {
      if (value == null) {
        throw new IllegalStateException("deletionCost cannot be null");
      }
      this.deletionCost = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> memoryUsageMb = JsonNullable.undefined();

    @JsonProperty("memory_usage_mb")
    public ContainerGroupInstanceBuilder memoryUsageMb(Double value) {
      if (value == null) {
        throw new IllegalStateException("memoryUsageMb cannot be null");
      }
      this.memoryUsageMb = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> memoryUsagePercent = JsonNullable.undefined();

    @JsonProperty("memory_usage_percent")
    public ContainerGroupInstanceBuilder memoryUsagePercent(Double value) {
      if (value == null) {
        throw new IllegalStateException("memoryUsagePercent cannot be null");
      }
      this.memoryUsagePercent = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> pullingProgress = JsonNullable.undefined();

    @JsonProperty("pulling_progress")
    public ContainerGroupInstanceBuilder pullingProgress(Double value) {
      if (value == null) {
        throw new IllegalStateException("pullingProgress cannot be null");
      }
      this.pullingProgress = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> ready = JsonNullable.undefined();

    @JsonProperty("ready")
    public ContainerGroupInstanceBuilder ready(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("ready cannot be null");
      }
      this.ready = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> sshHostKeyFingerprint = JsonNullable.undefined();

    @JsonProperty("ssh_host_key_fingerprint")
    public ContainerGroupInstanceBuilder sshHostKeyFingerprint(String value) {
      if (value == null) {
        throw new IllegalStateException("sshHostKeyFingerprint cannot be null");
      }
      this.sshHostKeyFingerprint = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> sshIp = JsonNullable.undefined();

    @JsonProperty("ssh_ip")
    public ContainerGroupInstanceBuilder sshIp(String value) {
      if (value == null) {
        throw new IllegalStateException("sshIp cannot be null");
      }
      this.sshIp = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> sshPort = JsonNullable.of(22L);

    @JsonProperty("ssh_port")
    public ContainerGroupInstanceBuilder sshPort(Long value) {
      if (value == null) {
        throw new IllegalStateException("sshPort cannot be null");
      }
      this.sshPort = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> started = JsonNullable.undefined();

    @JsonProperty("started")
    public ContainerGroupInstanceBuilder started(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("started cannot be null");
      }
      this.started = JsonNullable.of(value);
      return this;
    }
  }
}
