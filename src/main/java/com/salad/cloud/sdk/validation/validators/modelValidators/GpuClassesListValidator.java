package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClass;
import com.salad.cloud.sdk.models.GpuClassesList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class GpuClassesListValidator extends AbstractModelValidator<GpuClassesList> {

  public GpuClassesListValidator(String fieldName) {
    super(fieldName);
  }

  public GpuClassesListValidator() {}

  @Override
  protected Violation[] validateModel(GpuClassesList gpuClassesList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<GpuClass>("items").maxLength(100).itemValidator(new GpuClassValidator()),
        gpuClassesList.getItems()
      )
      .aggregate();
  }
}
