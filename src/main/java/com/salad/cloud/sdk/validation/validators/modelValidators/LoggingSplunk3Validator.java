package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingSplunk3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingSplunk3Validator extends AbstractModelValidator<LoggingSplunk3> {

  public LoggingSplunk3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingSplunk3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingSplunk3 loggingSplunk3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingSplunk3.getHost()))
      .add(new StringValidator("token").minLength(1).maxLength(1000).validate(loggingSplunk3.getToken()))
      .aggregate();
  }
}
