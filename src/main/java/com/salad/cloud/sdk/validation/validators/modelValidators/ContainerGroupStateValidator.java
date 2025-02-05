package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupState;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerGroupStateValidator extends AbstractModelValidator<ContainerGroupState> {

  public ContainerGroupStateValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupStateValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupState containerGroupState) {
    return new ViolationAggregator()
      .add(
        new ContainerGroupInstanceStatusCountValidator("instanceStatusCounts")
          .required()
          .validate(containerGroupState.getInstanceStatusCounts())
      )
      .aggregate();
  }
}
