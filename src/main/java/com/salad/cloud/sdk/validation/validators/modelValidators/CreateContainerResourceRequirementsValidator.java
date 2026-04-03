package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainerResourceRequirements;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for CreateContainerResourceRequirements model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreateContainerResourceRequirementsValidator
  extends AbstractModelValidator<CreateContainerResourceRequirements> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreateContainerResourceRequirementsValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreateContainerResourceRequirementsValidator() {}

  /**
   * Validates the CreateContainerResourceRequirements model's fields and constraints.
   *
   * @param createContainerResourceRequirements The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreateContainerResourceRequirements createContainerResourceRequirements) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("cpu")
          .min(1L)
          .max(1024L)
          .required()
          .validate(createContainerResourceRequirements.getCpu())
      )
      .add(
        new NumericValidator<Long>("memory")
          .min(1024L)
          .max(1073741824L)
          .required()
          .validate(createContainerResourceRequirements.getMemory())
      )
      .add(
        new ListValidator<String>("gpuClasses")
          .maxLength(100)
          .optional()
          .validate(createContainerResourceRequirements.getGpuClasses())
      )
      .add(
        new NumericValidator<Long>("shmSize")
          .min(64L)
          .max(1073741824L)
          .optional()
          .validate(createContainerResourceRequirements.getShmSize())
      )
      .add(
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(1125899906842624L)
          .optional()
          .validate(createContainerResourceRequirements.getStorageAmount())
      )
      .aggregate();
  }
}
