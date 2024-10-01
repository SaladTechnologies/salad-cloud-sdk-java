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
      .add(new LoggingAxiom2Validator("axiom").validate(createContainerLogging.getAxiom()))
      .add(new LoggingDatadog2Validator("datadog").validate(createContainerLogging.getDatadog()))
      .add(new LoggingNewRelic2Validator("newRelic").validate(createContainerLogging.getNewRelic()))
      .add(new LoggingSplunk2Validator("splunk").validate(createContainerLogging.getSplunk()))
      .add(new LoggingTcp2Validator("tcp").validate(createContainerLogging.getTcp()))
      .add(new LoggingHttp2Validator("http").validate(createContainerLogging.getHttp()))
      .aggregate();
  }
}
