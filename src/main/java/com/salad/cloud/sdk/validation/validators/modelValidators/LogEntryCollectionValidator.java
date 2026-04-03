package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntry;
import com.salad.cloud.sdk.models.LogEntryCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for LogEntryCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class LogEntryCollectionValidator extends AbstractModelValidator<LogEntryCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public LogEntryCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public LogEntryCollectionValidator() {}

  /**
   * Validates the LogEntryCollection model's fields and constraints.
   *
   * @param logEntryCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(LogEntryCollection logEntryCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<LogEntry>("items")
          .maxLength(10000)
          .itemValidator(new LogEntryValidator().required())
          .required()
          .validate(logEntryCollection.getItems())
      )
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(logEntryCollection.getOrganizationName())
      )
      .aggregate();
  }
}
