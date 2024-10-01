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
      .add(new LoggingAxiom3Validator("axiom").validate(updateContainerLogging.getAxiom()))
      .add(new LoggingDatadog3Validator("datadog").validate(updateContainerLogging.getDatadog()))
      .add(new LoggingNewRelic3Validator("newRelic").validate(updateContainerLogging.getNewRelic()))
      .add(new LoggingSplunk3Validator("splunk").validate(updateContainerLogging.getSplunk()))
      .add(new LoggingTcp3Validator("tcp").validate(updateContainerLogging.getTcp()))
      .add(new LoggingHttp3Validator("http").validate(updateContainerLogging.getHttp()))
      .aggregate();
  }
}
