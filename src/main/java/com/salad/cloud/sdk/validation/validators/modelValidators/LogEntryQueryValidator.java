package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntryQuery;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for LogEntryQuery model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class LogEntryQueryValidator extends AbstractModelValidator<LogEntryQuery> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public LogEntryQueryValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public LogEntryQueryValidator() {}

  /**
   * Validates the LogEntryQuery model's fields and constraints.
   *
   * @param logEntryQuery The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(LogEntryQuery logEntryQuery) {
    return new ViolationAggregator()
      .add(new StringValidator("query").maxLength(20000).required().validate(logEntryQuery.getQuery()))
      .add(new NumericValidator<Long>("pageSize").min(1L).max(100L).optional().validate(logEntryQuery.getPageSize()))
      .aggregate();
  }
}
