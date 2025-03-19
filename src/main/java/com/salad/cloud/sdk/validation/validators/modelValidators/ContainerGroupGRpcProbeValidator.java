package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupGRpcProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupGRpcProbeValidator extends AbstractModelValidator<ContainerGroupGRpcProbe> {

  public ContainerGroupGRpcProbeValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupGRpcProbeValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupGRpcProbe containerGroupGRpcProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port").min(0L).max(65536L).required().validate(containerGroupGRpcProbe.getPort())
      )
      .add(
        new StringValidator("service")
          .maxLength(1024)
          .pattern("^.*$")
          .required()
          .validate(containerGroupGRpcProbe.getService())
      )
      .aggregate();
  }
}
