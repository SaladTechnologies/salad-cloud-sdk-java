package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.HttpHeaders3;
import com.salad.cloud.sdk.models.LoggingHttp2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingHttp2Validator extends AbstractModelValidator<LoggingHttp2> {

  public LoggingHttp2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingHttp2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingHttp2 loggingHttp2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingHttp2.getHost())
      .add(new NumericValidator<Long>("port").min(1L).max(65535L), loggingHttp2.getPort())
      .add(new ListValidator<HttpHeaders3>("headers").maxLength(1000), loggingHttp2.getHeaders())
      .aggregate();
  }
}
