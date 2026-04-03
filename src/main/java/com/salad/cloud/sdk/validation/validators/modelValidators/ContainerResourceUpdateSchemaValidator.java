package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerResourceUpdateSchema;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerResourceUpdateSchema model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerResourceUpdateSchemaValidator extends AbstractModelValidator<ContainerResourceUpdateSchema> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerResourceUpdateSchemaValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerResourceUpdateSchemaValidator() {}

  /**
   * Validates the ContainerResourceUpdateSchema model's fields and constraints.
   *
   * @param containerResourceUpdateSchema The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerResourceUpdateSchema containerResourceUpdateSchema) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("cpu").min(1L).max(1024L).optional().validate(containerResourceUpdateSchema.getCpu())
      )
      .add(
        new ListValidator<String>("gpuClasses")
          .maxLength(100)
          .optional()
          .validate(containerResourceUpdateSchema.getGpuClasses())
      )
      .add(
        new NumericValidator<Long>("memory")
          .min(1024L)
          .max(1073741824L)
          .optional()
          .validate(containerResourceUpdateSchema.getMemory())
      )
      .add(
        new NumericValidator<Long>("shmSize")
          .min(64L)
          .max(1073741824L)
          .optional()
          .validate(containerResourceUpdateSchema.getShmSize())
      )
      .add(
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(1125899906842624L)
          .optional()
          .validate(containerResourceUpdateSchema.getStorageAmount())
      )
      .aggregate();
  }
}
