package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClass;
import com.salad.cloud.sdk.models.GpuClassPrice;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class GpuClassValidator extends AbstractModelValidator<GpuClass> {

  public GpuClassValidator(String fieldName) {
    super(fieldName);
  }

  public GpuClassValidator() {}

  @Override
  protected Violation[] validateModel(GpuClass gpuClass) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ -~]{2,63}$")
          .required()
          .validate(gpuClass.getName())
      )
      .add(
        new ListValidator<GpuClassPrice>("prices")
          .minLength(1)
          .maxLength(100)
          .itemValidator(new GpuClassPriceValidator().required())
          .required()
          .validate(gpuClass.getPrices())
      )
      .add(new NumericValidator<Long>("gpuCount").min(1L).max(512L).optional().validate(gpuClass.getGpuCount()))
      .add(new NumericValidator<Long>("minVcpu").min(0L).optional().validate(gpuClass.getMinVcpu()))
      .add(new NumericValidator<Long>("maxVcpu").min(0L).optional().validate(gpuClass.getMaxVcpu()))
      .add(new NumericValidator<Long>("minRam").min(0L).optional().validate(gpuClass.getMinRam()))
      .add(new NumericValidator<Long>("maxRam").min(0L).optional().validate(gpuClass.getMaxRam()))
      .add(new NumericValidator<Long>("minStorage").min(0L).optional().validate(gpuClass.getMinStorage()))
      .add(new NumericValidator<Long>("maxStorage").min(0L).optional().validate(gpuClass.getMaxStorage()))
      .aggregate();
  }
}
