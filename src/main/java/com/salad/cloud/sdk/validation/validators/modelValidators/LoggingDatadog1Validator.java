package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogTags1;
import com.salad.cloud.sdk.models.LoggingDatadog1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingDatadog1Validator extends AbstractModelValidator<LoggingDatadog1> {

  public LoggingDatadog1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingDatadog1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingDatadog1 loggingDatadog1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingDatadog1.getHost())
      .add(new StringValidator("apiKey").minLength(1).maxLength(1000), loggingDatadog1.getApiKey())
      .add(new ListValidator<DatadogTags1>("tags").maxLength(1000), loggingDatadog1.getTags())
      .aggregate();
  }
}
