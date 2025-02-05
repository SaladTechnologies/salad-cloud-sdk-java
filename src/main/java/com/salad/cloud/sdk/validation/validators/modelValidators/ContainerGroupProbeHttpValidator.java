package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeHttp;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupProbeHttpValidator extends AbstractModelValidator<ContainerGroupProbeHttp> {

  public ContainerGroupProbeHttpValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupProbeHttpValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupProbeHttp containerGroupProbeHttp) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port").min(0L).max(65536L).required().validate(containerGroupProbeHttp.getPort())
      )
      .aggregate();
  }
}
