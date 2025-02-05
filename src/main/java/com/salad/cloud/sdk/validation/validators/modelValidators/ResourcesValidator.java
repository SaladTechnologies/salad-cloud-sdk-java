package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Resources;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ResourcesValidator extends AbstractModelValidator<Resources> {

  public ResourcesValidator(String fieldName) {
    super(fieldName);
  }

  public ResourcesValidator() {}

  @Override
  protected Violation[] validateModel(Resources resources) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("cpu").min(1L).max(16L).optional().validate(resources.getCpu()))
      .add(new NumericValidator<Long>("memory").min(1024L).max(61440L).optional().validate(resources.getMemory()))
      .add(
        new NumericValidator<Long>("storageAmount")
          .min(1073741824L)
          .max(53687091200L)
          .optional()
          .validate(resources.getStorageAmount())
      )
      .aggregate();
  }
}
