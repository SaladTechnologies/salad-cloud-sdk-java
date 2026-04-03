package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupScalingAction;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupScalingAction model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupScalingActionValidator extends AbstractModelValidator<ContainerGroupScalingAction> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupScalingActionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupScalingActionValidator() {}

  /**
   * Validates the ContainerGroupScalingAction model's fields and constraints.
   *
   * @param containerGroupScalingAction The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupScalingAction containerGroupScalingAction) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("replicas")
          .min(0L)
          .max(500L)
          .required()
          .validate(containerGroupScalingAction.getReplicas())
      )
      .add(
        new StringValidator("schedule")
          .pattern("^([0-9A-Za-z*/,-]+)([\\t ]+[0-9A-Za-z*/,-]+){4}$")
          .required()
          .validate(containerGroupScalingAction.getSchedule())
      )
      .aggregate();
  }
}
