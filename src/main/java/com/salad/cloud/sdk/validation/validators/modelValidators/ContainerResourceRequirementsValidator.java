package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerResourceRequirements;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerResourceRequirements model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerResourceRequirementsValidator extends AbstractModelValidator<ContainerResourceRequirements> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerResourceRequirementsValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerResourceRequirementsValidator() {}

  /**
   * Validates the ContainerResourceRequirements model's fields and constraints.
   *
   * @param containerResourceRequirements The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerResourceRequirements containerResourceRequirements) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("cpu").min(1L).max(1024L).required().validate(containerResourceRequirements.getCpu())
      )
      .add(
        new ListValidator<String>("gpuClasses")
          .maxLength(100)
          .required()
          .validate(containerResourceRequirements.getGpuClasses())
      )
      .add(
        new NumericValidator<Long>("memory")
          .min(1024L)
          .max(1073741824L)
          .required()
          .validate(containerResourceRequirements.getMemory())
      )
      .add(
        new NumericValidator<Long>("shmSize")
          .min(64L)
          .max(1073741824L)
          .optional()
          .validate(containerResourceRequirements.getShmSize())
      )
      .add(
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(1125899906842624L)
          .optional()
          .validate(containerResourceRequirements.getStorageAmount())
      )
      .aggregate();
  }
}
