package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.HttpHeaders4;
import com.salad.cloud.sdk.models.LoggingHttp3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingHttp3Validator extends AbstractModelValidator<LoggingHttp3> {

  public LoggingHttp3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingHttp3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingHttp3 loggingHttp3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingHttp3.getHost()))
      .add(new NumericValidator<Long>("port").min(1L).max(65535L).validate(loggingHttp3.getPort()))
      .add(new ListValidator<HttpHeaders4>("headers").maxLength(1000).validate(loggingHttp3.getHeaders()))
      .aggregate();
  }
}
