package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstances;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class ContainerGroupInstancesValidator extends AbstractModelValidator<ContainerGroupInstances> {

  public ContainerGroupInstancesValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupInstancesValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupInstances containerGroupInstances) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroupInstance>("instances")
          .maxLength(1000)
          .validate(containerGroupInstances.getInstances())
      )
      .aggregate();
  }
}
