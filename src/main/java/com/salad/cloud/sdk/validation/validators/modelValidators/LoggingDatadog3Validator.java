package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogTags3;
import com.salad.cloud.sdk.models.LoggingDatadog3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingDatadog3Validator extends AbstractModelValidator<LoggingDatadog3> {

  public LoggingDatadog3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingDatadog3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingDatadog3 loggingDatadog3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000).validate(loggingDatadog3.getHost()))
      .add(new StringValidator("apiKey").minLength(1).maxLength(1000).validate(loggingDatadog3.getApiKey()))
      .add(new ListValidator<DatadogTags3>("tags").maxLength(1000).validate(loggingDatadog3.getTags()))
      .aggregate();
  }
}
