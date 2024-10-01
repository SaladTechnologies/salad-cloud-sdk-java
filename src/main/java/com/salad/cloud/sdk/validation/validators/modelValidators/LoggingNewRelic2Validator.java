package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingNewRelic2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingNewRelic2Validator extends AbstractModelValidator<LoggingNewRelic2> {

  public LoggingNewRelic2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingNewRelic2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingNewRelic2 loggingNewRelic2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingNewRelic2.getHost()))
      .add(
        new StringValidator("ingestionKey").minLength(1).maxLength(1000).validate(loggingNewRelic2.getIngestionKey())
      )
      .aggregate();
  }
}
