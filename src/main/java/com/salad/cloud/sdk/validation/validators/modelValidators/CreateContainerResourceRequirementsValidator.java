package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainerResourceRequirements;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class CreateContainerResourceRequirementsValidator
  extends AbstractModelValidator<CreateContainerResourceRequirements> {

  public CreateContainerResourceRequirementsValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerResourceRequirementsValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainerResourceRequirements createContainerResourceRequirements) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("cpu")
          .min(1L)
          .max(16L)
          .required()
          .validate(createContainerResourceRequirements.getCpu())
      )
      .add(
        new NumericValidator<Long>("memory")
          .min(1024L)
          .max(61440L)
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
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(268435456000L)
          .optional()
          .validate(createContainerResourceRequirements.getStorageAmount())
      )
      .add(
        new NumericValidator<Long>("shmSize")
          .min(64L)
          .max(2147483647L)
          .optional()
          .validate(createContainerResourceRequirements.getShmSize())
      )
      .aggregate();
  }
}
