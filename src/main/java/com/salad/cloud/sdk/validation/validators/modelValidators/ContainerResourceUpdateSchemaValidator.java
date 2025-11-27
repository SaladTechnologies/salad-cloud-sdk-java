package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerResourceUpdateSchema;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerResourceUpdateSchemaValidator extends AbstractModelValidator<ContainerResourceUpdateSchema> {

  public ContainerResourceUpdateSchemaValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerResourceUpdateSchemaValidator() {}

  @Override
  protected Violation[] validateModel(ContainerResourceUpdateSchema containerResourceUpdateSchema) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("cpu").min(1L).max(1024L).optional().validate(containerResourceUpdateSchema.getCpu())
      )
      .add(
        new NumericValidator<Long>("memory")
          .min(1024L)
          .max(1073741824L)
          .optional()
          .validate(containerResourceUpdateSchema.getMemory())
      )
      .add(
        new ListValidator<String>("gpuClasses")
          .maxLength(100)
          .optional()
          .validate(containerResourceUpdateSchema.getGpuClasses())
      )
      .add(
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(1125899906842624L)
          .optional()
          .validate(containerResourceUpdateSchema.getStorageAmount())
      )
      .add(
        new NumericValidator<Long>("shmSize")
          .min(64L)
          .max(1073741824L)
          .optional()
          .validate(containerResourceUpdateSchema.getShmSize())
      )
      .aggregate();
  }
}
