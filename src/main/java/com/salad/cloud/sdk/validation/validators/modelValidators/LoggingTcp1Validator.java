package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingTcp1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingTcp1Validator extends AbstractModelValidator<LoggingTcp1> {

  public LoggingTcp1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingTcp1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingTcp1 loggingTcp1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingTcp1.getHost()))
      .add(new NumericValidator<Long>("port").min(1L).max(65535L).validate(loggingTcp1.getPort()))
      .aggregate();
  }
}
