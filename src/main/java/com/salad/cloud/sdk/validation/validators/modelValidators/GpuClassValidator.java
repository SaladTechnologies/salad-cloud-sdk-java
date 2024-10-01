package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClass;
import com.salad.cloud.sdk.models.GpuClassPrice;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class GpuClassValidator extends AbstractModelValidator<GpuClass> {

  public GpuClassValidator(String fieldName) {
    super(fieldName);
  }

  public GpuClassValidator() {}

  @Override
  protected Violation[] validateModel(GpuClass gpuClass) {
    return new ViolationAggregator()
      .add(new StringValidator("name").minLength(2).maxLength(63).validate(gpuClass.getName()))
      .add(
        new ListValidator<GpuClassPrice>("prices")
          .minLength(1)
          .maxLength(100)
          .itemValidator(new GpuClassPriceValidator())
          .validate(gpuClass.getPrices())
      )
      .aggregate();
  }
}
