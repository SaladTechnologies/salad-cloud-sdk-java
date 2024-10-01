package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClassPrice;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class GpuClassPriceValidator extends AbstractModelValidator<GpuClassPrice> {

  public GpuClassPriceValidator(String fieldName) {
    super(fieldName);
  }

  public GpuClassPriceValidator() {}

  @Override
  protected Violation[] validateModel(GpuClassPrice gpuClassPrice) {
    return new ViolationAggregator()
      .add(new StringValidator("price").minLength(1).maxLength(20).validate(gpuClassPrice.getPrice()))
      .aggregate();
  }
}
