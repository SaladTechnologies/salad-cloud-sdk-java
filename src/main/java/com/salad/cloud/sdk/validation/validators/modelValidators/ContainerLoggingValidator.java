package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerLoggingValidator extends AbstractModelValidator<ContainerLogging> {

  public ContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(ContainerLogging containerLogging) {
    return new ViolationAggregator()
      .add(new LoggingAxiom1Validator("axiom").validate(containerLogging.getAxiom()))
      .add(new LoggingDatadog1Validator("datadog").validate(containerLogging.getDatadog()))
      .add(new LoggingNewRelic1Validator("newRelic").validate(containerLogging.getNewRelic()))
      .add(new LoggingSplunk1Validator("splunk").validate(containerLogging.getSplunk()))
      .add(new LoggingTcp1Validator("tcp").validate(containerLogging.getTcp()))
      .add(new LoggingHttp1Validator("http").validate(containerLogging.getHttp()))
      .aggregate();
  }
}
