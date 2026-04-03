package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupNetworkingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupNetworkingConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupNetworkingConfigurationValidator
  extends AbstractModelValidator<ContainerGroupNetworkingConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupNetworkingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupNetworkingConfigurationValidator() {}

  /**
   * Validates the ContainerGroupNetworkingConfiguration model's fields and constraints.
   *
   * @param containerGroupNetworkingConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupNetworkingConfiguration containerGroupNetworkingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("dns")
          .minLength(1)
          .maxLength(253)
          .pattern("^([a-z][a-z0-9-]{0,61}[a-z0-9]\\.)*[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroupNetworkingConfiguration.getDns())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerGroupNetworkingConfiguration.getPort())
      )
      .add(
        new NumericValidator<Long>("clientRequestTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworkingConfiguration.getClientRequestTimeout())
      )
      .add(
        new NumericValidator<Long>("serverResponseTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworkingConfiguration.getServerResponseTimeout())
      )
      .aggregate();
  }
}
