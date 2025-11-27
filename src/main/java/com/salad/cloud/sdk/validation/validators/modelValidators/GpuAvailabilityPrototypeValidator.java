package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuAvailabilityPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class GpuAvailabilityPrototypeValidator extends AbstractModelValidator<GpuAvailabilityPrototype> {

  public GpuAvailabilityPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  public GpuAvailabilityPrototypeValidator() {}

  @Override
  protected Violation[] validateModel(GpuAvailabilityPrototype gpuAvailabilityPrototype) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("gpuClasses")
          .minLength(1)
          .required()
          .validate(gpuAvailabilityPrototype.getGpuClasses())
      )
      .aggregate();
  }
}
