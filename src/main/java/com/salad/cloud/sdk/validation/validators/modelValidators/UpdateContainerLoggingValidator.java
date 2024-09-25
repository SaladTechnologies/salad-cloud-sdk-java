package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class UpdateContainerLoggingValidator extends AbstractModelValidator<UpdateContainerLogging> {

  public UpdateContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(UpdateContainerLogging updateContainerLogging) {
    return new ViolationAggregator()
      .add(new LoggingAxiom3Validator("axiom"), updateContainerLogging.getAxiom())
      .add(new LoggingDatadog3Validator("datadog"), updateContainerLogging.getDatadog())
      .add(new LoggingNewRelic3Validator("newRelic"), updateContainerLogging.getNewRelic())
      .add(new LoggingSplunk3Validator("splunk"), updateContainerLogging.getSplunk())
      .add(new LoggingTcp3Validator("tcp"), updateContainerLogging.getTcp())
      .add(new LoggingHttp3Validator("http"), updateContainerLogging.getHttp())
      .aggregate();
  }
}
