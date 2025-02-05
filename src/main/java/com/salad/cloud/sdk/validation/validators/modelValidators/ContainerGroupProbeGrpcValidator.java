package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeGrpc;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupProbeGrpcValidator extends AbstractModelValidator<ContainerGroupProbeGrpc> {

  public ContainerGroupProbeGrpcValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupProbeGrpcValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupProbeGrpc containerGroupProbeGrpc) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port").min(0L).max(65536L).required().validate(containerGroupProbeGrpc.getPort())
      )
      .aggregate();
  }
}
