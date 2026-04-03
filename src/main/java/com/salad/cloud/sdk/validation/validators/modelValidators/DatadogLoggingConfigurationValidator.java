package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogLoggingConfiguration;
import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for DatadogLoggingConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class DatadogLoggingConfigurationValidator extends AbstractModelValidator<DatadogLoggingConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public DatadogLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public DatadogLoggingConfigurationValidator() {}

  /**
   * Validates the DatadogLoggingConfiguration model's fields and constraints.
   *
   * @param datadogLoggingConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(DatadogLoggingConfiguration datadogLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("apiKey")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogLoggingConfiguration.getApiKey())
      )
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogLoggingConfiguration.getHost())
      )
      .add(
        new ListValidator<DatadogTagForContainerLogging>("tags")
          .maxLength(1000)
          .itemValidator(new DatadogTagForContainerLoggingValidator().required())
          .optional()
          .validate(datadogLoggingConfiguration.getTags())
      )
      .aggregate();
  }
}
