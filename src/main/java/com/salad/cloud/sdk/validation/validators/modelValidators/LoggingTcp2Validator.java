package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingTcp2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingTcp2Validator extends AbstractModelValidator<LoggingTcp2> {

  public LoggingTcp2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingTcp2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingTcp2 loggingTcp2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingTcp2.getHost()))
      .add(new NumericValidator<Long>("port").min(1L).max(65535L).validate(loggingTcp2.getPort()))
      .aggregate();
  }
}
