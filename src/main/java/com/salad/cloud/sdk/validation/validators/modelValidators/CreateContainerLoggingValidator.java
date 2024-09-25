package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class CreateContainerLoggingValidator extends AbstractModelValidator<CreateContainerLogging> {

  public CreateContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainerLogging createContainerLogging) {
    return new ViolationAggregator()
      .add(new LoggingAxiom2Validator("axiom"), createContainerLogging.getAxiom())
      .add(new LoggingDatadog2Validator("datadog"), createContainerLogging.getDatadog())
      .add(new LoggingNewRelic2Validator("newRelic"), createContainerLogging.getNewRelic())
      .add(new LoggingSplunk2Validator("splunk"), createContainerLogging.getSplunk())
      .add(new LoggingTcp2Validator("tcp"), createContainerLogging.getTcp())
      .add(new LoggingHttp2Validator("http"), createContainerLogging.getHttp())
      .aggregate();
  }
}
