package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingTcp3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingTcp3Validator extends AbstractModelValidator<LoggingTcp3> {

  public LoggingTcp3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingTcp3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingTcp3 loggingTcp3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingTcp3.getHost())
      .add(new NumericValidator<Long>("port").min(1L).max(65535L), loggingTcp3.getPort())
      .aggregate();
  }
}
