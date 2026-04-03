package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingSplunkConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerLoggingSplunkConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerLoggingSplunkConfigurationValidator
  extends AbstractModelValidator<ContainerLoggingSplunkConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerLoggingSplunkConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerLoggingSplunkConfigurationValidator() {}

  /**
   * Validates the ContainerLoggingSplunkConfiguration model's fields and constraints.
   *
   * @param containerLoggingSplunkConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingSplunkConfiguration.getHost())
      )
      .add(
        new StringValidator("token")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingSplunkConfiguration.getToken())
      )
      .aggregate();
  }
}
