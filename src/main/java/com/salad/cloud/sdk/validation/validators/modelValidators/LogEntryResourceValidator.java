package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntryResource;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for LogEntryResource model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class LogEntryResourceValidator extends AbstractModelValidator<LogEntryResource> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public LogEntryResourceValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public LogEntryResourceValidator() {}

  /**
   * Validates the LogEntryResource model's fields and constraints.
   *
   * @param logEntryResource The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(LogEntryResource logEntryResource) {
    return new ViolationAggregator()
      .add(new StringValidator("type").minLength(1).maxLength(1000).required().validate(logEntryResource.getType()))
      .aggregate();
  }
}
