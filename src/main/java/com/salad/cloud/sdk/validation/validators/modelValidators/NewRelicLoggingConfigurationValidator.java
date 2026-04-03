package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.NewRelicLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for NewRelicLoggingConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class NewRelicLoggingConfigurationValidator extends AbstractModelValidator<NewRelicLoggingConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public NewRelicLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public NewRelicLoggingConfigurationValidator() {}

  /**
   * Validates the NewRelicLoggingConfiguration model's fields and constraints.
   *
   * @param newRelicLoggingConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(NewRelicLoggingConfiguration newRelicLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(newRelicLoggingConfiguration.getHost())
      )
      .add(
        new StringValidator("ingestionKey")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(newRelicLoggingConfiguration.getIngestionKey())
      )
      .aggregate();
  }
}
