package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupTcpProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupTcpProbeValidator extends AbstractModelValidator<ContainerGroupTcpProbe> {

  public ContainerGroupTcpProbeValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupTcpProbeValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupTcpProbe containerGroupTcpProbe) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("port").min(0L).max(65535L).required().validate(containerGroupTcpProbe.getPort()))
      .aggregate();
  }
}
