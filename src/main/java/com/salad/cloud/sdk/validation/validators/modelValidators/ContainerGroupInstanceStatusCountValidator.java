package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstanceStatusCount;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupInstanceStatusCount model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupInstanceStatusCountValidator
  extends AbstractModelValidator<ContainerGroupInstanceStatusCount> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupInstanceStatusCountValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupInstanceStatusCountValidator() {}

  /**
   * Validates the ContainerGroupInstanceStatusCount model's fields and constraints.
   *
   * @param containerGroupInstanceStatusCount The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupInstanceStatusCount containerGroupInstanceStatusCount) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("allocatingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getAllocatingCount())
      )
      .add(
        new NumericValidator<Long>("creatingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getCreatingCount())
      )
      .add(
        new NumericValidator<Long>("runningCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getRunningCount())
      )
      .add(
        new NumericValidator<Long>("stoppingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getStoppingCount())
      )
      .aggregate();
  }
}
