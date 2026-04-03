package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainerGroupNetworking;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for CreateContainerGroupNetworking model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreateContainerGroupNetworkingValidator extends AbstractModelValidator<CreateContainerGroupNetworking> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreateContainerGroupNetworkingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreateContainerGroupNetworkingValidator() {}

  /**
   * Validates the CreateContainerGroupNetworking model's fields and constraints.
   *
   * @param createContainerGroupNetworking The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreateContainerGroupNetworking createContainerGroupNetworking) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(createContainerGroupNetworking.getPort())
      )
      .add(
        new NumericValidator<Long>("clientRequestTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(createContainerGroupNetworking.getClientRequestTimeout())
      )
      .add(
        new NumericValidator<Long>("serverResponseTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(createContainerGroupNetworking.getServerResponseTimeout())
      )
      .aggregate();
  }
}
