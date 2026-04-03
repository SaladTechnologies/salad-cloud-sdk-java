package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupState;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupState model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupStateValidator extends AbstractModelValidator<ContainerGroupState> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupStateValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupStateValidator() {}

  /**
   * Validates the ContainerGroupState model's fields and constraints.
   *
   * @param containerGroupState The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupState containerGroupState) {
    return new ViolationAggregator()
      .add(
        new ContainerGroupInstanceStatusCountValidator("instanceStatusCounts")
          .required()
          .validate(containerGroupState.getInstanceStatusCounts())
      )
      .add(
        new StringValidator("description")
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerGroupState.getDescription())
      )
      .aggregate();
  }
}
