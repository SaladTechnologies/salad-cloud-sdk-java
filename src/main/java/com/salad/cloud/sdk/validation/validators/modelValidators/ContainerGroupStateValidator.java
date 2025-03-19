package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupState;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

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
      .add(
        new StringValidator("description")
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerGroupState.getDescription())
      )
      .aggregate();
  }
}
