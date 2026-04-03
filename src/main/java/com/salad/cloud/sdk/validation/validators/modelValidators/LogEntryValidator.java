package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntry;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for LogEntry model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class LogEntryValidator extends AbstractModelValidator<LogEntry> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public LogEntryValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public LogEntryValidator() {}

  /**
   * Validates the LogEntry model's fields and constraints.
   *
   * @param logEntry The model instance to validate
   * @return Array of violations found during validation
   */
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
