package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingSplunk1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingSplunk1Validator extends AbstractModelValidator<LoggingSplunk1> {

  public LoggingSplunk1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingSplunk1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingSplunk1 loggingSplunk1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingSplunk1.getHost())
      .add(new StringValidator("token").minLength(1).maxLength(1000), loggingSplunk1.getToken())
      .aggregate();
  }
}
