package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainerGroupNetworking;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for UpdateContainerGroupNetworking model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class UpdateContainerGroupNetworkingValidator extends AbstractModelValidator<UpdateContainerGroupNetworking> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public UpdateContainerGroupNetworkingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public UpdateContainerGroupNetworkingValidator() {}

  /**
   * Validates the UpdateContainerGroupNetworking model's fields and constraints.
   *
   * @param updateContainerGroupNetworking The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(UpdateContainerGroupNetworking updateContainerGroupNetworking) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .optional()
          .validate(updateContainerGroupNetworking.getPort())
      )
      .aggregate();
  }
}
