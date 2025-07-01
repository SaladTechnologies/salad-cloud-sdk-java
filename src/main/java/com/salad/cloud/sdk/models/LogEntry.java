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

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class LogEntry {

  /**
   * The time when the log entry was received
   */
  @NonNull
  @JsonProperty("receive_time")
  private String receiveTime;

  /**
   * The resource associated with the log entry
   */
  @NonNull
  private LogEntryResource resource;

  /**
   * The severity level of the log entry
   */
  @NonNull
  private LogEntrySeverity severity;

  /**
   * The timestamp of the log entry
   */
  @NonNull
  private String time;

  /**
   * The log message in JSON format.
   */
  @JsonProperty("json_log")
  private JsonNullable<Object> jsonLog;

  /**
   * The parent span ID of the log entry
   */
  @JsonProperty("parent_span_id")
  private JsonNullable<String> parentSpanId;

  /**
   * The span ID of the log entry
   */
  @JsonProperty("span_Id")
  private JsonNullable<String> spanId;

  /**
   * The log message in text format.
   */
  @JsonProperty("text_log")
  private JsonNullable<String> textLog;

  /**
   * The trace ID of the log entry
   */
  @JsonProperty("trace_Id")
  private JsonNullable<String> traceId;

  @JsonIgnore
  public Object getJsonLog() {
    return jsonLog.orElse(null);
  }

  @JsonIgnore
  public String getParentSpanId() {
    return parentSpanId.orElse(null);
  }

  @JsonIgnore
  public String getSpanId() {
    return spanId.orElse(null);
  }

  @JsonIgnore
  public String getTextLog() {
    return textLog.orElse(null);
  }

  @JsonIgnore
  public String getTraceId() {
    return traceId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class LogEntryBuilder {

    private JsonNullable<Object> jsonLog = JsonNullable.undefined();

    @JsonProperty("json_log")
    public LogEntryBuilder jsonLog(Object value) {
      if (value == null) {
        throw new IllegalStateException("jsonLog cannot be null");
      }
      this.jsonLog = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> parentSpanId = JsonNullable.undefined();

    @JsonProperty("parent_span_id")
    public LogEntryBuilder parentSpanId(String value) {
      if (value == null) {
        throw new IllegalStateException("parentSpanId cannot be null");
      }
      this.parentSpanId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> spanId = JsonNullable.undefined();

    @JsonProperty("span_Id")
    public LogEntryBuilder spanId(String value) {
      if (value == null) {
        throw new IllegalStateException("spanId cannot be null");
      }
      this.spanId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> textLog = JsonNullable.undefined();

    @JsonProperty("text_log")
    public LogEntryBuilder textLog(String value) {
      if (value == null) {
        throw new IllegalStateException("textLog cannot be null");
      }
      this.textLog = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> traceId = JsonNullable.undefined();

    @JsonProperty("trace_Id")
    public LogEntryBuilder traceId(String value) {
      if (value == null) {
        throw new IllegalStateException("traceId cannot be null");
      }
      this.traceId = JsonNullable.of(value);
      return this;
    }
  }
}
