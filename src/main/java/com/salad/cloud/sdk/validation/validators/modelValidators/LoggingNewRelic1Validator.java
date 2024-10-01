package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingNewRelic1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingNewRelic1Validator extends AbstractModelValidator<LoggingNewRelic1> {

  public LoggingNewRelic1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingNewRelic1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingNewRelic1 loggingNewRelic1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingNewRelic1.getHost()))
      .add(
        new StringValidator("ingestionKey").minLength(1).maxLength(1000).validate(loggingNewRelic1.getIngestionKey())
      )
      .aggregate();
  }
}
