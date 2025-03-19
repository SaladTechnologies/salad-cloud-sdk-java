package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstanceStatusCount;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupInstanceStatusCountValidator
  extends AbstractModelValidator<ContainerGroupInstanceStatusCount> {

  public ContainerGroupInstanceStatusCountValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupInstanceStatusCountValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupInstanceStatusCount containerGroupInstanceStatusCount) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("allocatingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getAllocatingCount())
      )
      .add(
        new NumericValidator<Long>("creatingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getCreatingCount())
      )
      .add(
        new NumericValidator<Long>("runningCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getRunningCount())
      )
      .add(
        new NumericValidator<Long>("stoppingCount")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstanceStatusCount.getStoppingCount())
      )
      .aggregate();
  }
}
