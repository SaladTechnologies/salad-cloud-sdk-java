package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for DatadogTagForContainerLogging model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class DatadogTagForContainerLoggingValidator extends AbstractModelValidator<DatadogTagForContainerLogging> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public DatadogTagForContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public DatadogTagForContainerLoggingValidator() {}

  /**
   * Validates the DatadogTagForContainerLogging model's fields and constraints.
   *
   * @param datadogTagForContainerLogging The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(DatadogTagForContainerLogging datadogTagForContainerLogging) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogTagForContainerLogging.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogTagForContainerLogging.getValue())
      )
      .aggregate();
  }
}
