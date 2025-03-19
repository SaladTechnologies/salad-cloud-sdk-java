package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstancePatch;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupInstancePatchValidator extends AbstractModelValidator<ContainerGroupInstancePatch> {

  public ContainerGroupInstancePatchValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupInstancePatchValidator() {}

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
