package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.HttpHeaders1;
import com.salad.cloud.sdk.models.LoggingHttp1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingHttp1Validator extends AbstractModelValidator<LoggingHttp1> {

  public LoggingHttp1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingHttp1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingHttp1 loggingHttp1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingHttp1.getHost()))
      .add(new NumericValidator<Long>("port").min(1L).max(65535L).validate(loggingHttp1.getPort()))
      .add(new ListValidator<HttpHeaders1>("headers").maxLength(1000).validate(loggingHttp1.getHeaders()))
      .aggregate();
  }
}
