package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstancePatch;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupInstancePatch model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupInstancePatchValidator extends AbstractModelValidator<ContainerGroupInstancePatch> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupInstancePatchValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupInstancePatchValidator() {}

  /**
   * Validates the ContainerGroupInstancePatch model's fields and constraints.
   *
   * @param containerGroupInstancePatch The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupInstancePatch containerGroupInstancePatch) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("deletionCost")
          .min(0L)
          .max(100000L)
          .optional()
          .validate(containerGroupInstancePatch.getDeletionCost())
      )
      .aggregate();
  }
}
