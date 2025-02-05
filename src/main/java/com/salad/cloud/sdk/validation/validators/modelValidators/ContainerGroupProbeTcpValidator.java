package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeTcp;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupProbeTcpValidator extends AbstractModelValidator<ContainerGroupProbeTcp> {

  public ContainerGroupProbeTcpValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupProbeTcpValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupProbeTcp containerGroupProbeTcp) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("port").min(0L).max(65536L).required().validate(containerGroupProbeTcp.getPort()))
      .aggregate();
  }
}
