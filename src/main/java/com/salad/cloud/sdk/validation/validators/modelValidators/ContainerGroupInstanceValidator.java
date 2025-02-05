package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupInstanceValidator extends AbstractModelValidator<ContainerGroupInstance> {

  public ContainerGroupInstanceValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupInstanceValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupInstance containerGroupInstance) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("version").min(1L).required().validate(containerGroupInstance.getVersion()))
      .aggregate();
  }
}
