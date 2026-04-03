package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.AxiomLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for AxiomLoggingConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class AxiomLoggingConfigurationValidator extends AbstractModelValidator<AxiomLoggingConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public AxiomLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public AxiomLoggingConfigurationValidator() {}

  /**
   * Validates the AxiomLoggingConfiguration model's fields and constraints.
   *
   * @param axiomLoggingConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(AxiomLoggingConfiguration axiomLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("apiToken")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getApiToken())
      )
      .add(
        new StringValidator("dataset")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getDataset())
      )
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getHost())
      )
      .aggregate();
  }
}
