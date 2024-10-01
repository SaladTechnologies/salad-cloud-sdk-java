package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingSplunk2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingSplunk2Validator extends AbstractModelValidator<LoggingSplunk2> {

  public LoggingSplunk2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingSplunk2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingSplunk2 loggingSplunk2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingSplunk2.getHost()))
      .add(new StringValidator("token").minLength(1).maxLength(1000).validate(loggingSplunk2.getToken()))
      .aggregate();
  }
}
