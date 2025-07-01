package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntry;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LogEntryValidator extends AbstractModelValidator<LogEntry> {

  public LogEntryValidator(String fieldName) {
    super(fieldName);
  }

  public LogEntryValidator() {}

  @Override
  protected Violation[] validateModel(LogEntry logEntry) {
    return new ViolationAggregator()
      .add(new LogEntryResourceValidator("resource").required().validate(logEntry.getResource()))
      .add(
        new StringValidator("parentSpanId").minLength(1).maxLength(1000).optional().validate(logEntry.getParentSpanId())
      )
      .add(new StringValidator("spanId").minLength(1).maxLength(1000).optional().validate(logEntry.getSpanId()))
      .add(new StringValidator("textLog").maxLength(10000).optional().validate(logEntry.getTextLog()))
      .add(new StringValidator("traceId").minLength(1).maxLength(1000).optional().validate(logEntry.getTraceId()))
      .aggregate();
  }
}
