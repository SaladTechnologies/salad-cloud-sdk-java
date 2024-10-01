package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingNewRelic3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingNewRelic3Validator extends AbstractModelValidator<LoggingNewRelic3> {

  public LoggingNewRelic3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingNewRelic3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingNewRelic3 loggingNewRelic3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingNewRelic3.getHost()))
      .add(
        new StringValidator("ingestionKey").minLength(1).maxLength(1000).validate(loggingNewRelic3.getIngestionKey())
      )
      .aggregate();
  }
}
