package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogTags2;
import com.salad.cloud.sdk.models.LoggingDatadog2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingDatadog2Validator extends AbstractModelValidator<LoggingDatadog2> {

  public LoggingDatadog2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingDatadog2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingDatadog2 loggingDatadog2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingDatadog2.getHost())
      .add(new StringValidator("apiKey").minLength(1).maxLength(1000), loggingDatadog2.getApiKey())
      .add(new ListValidator<DatadogTags2>("tags").maxLength(1000), loggingDatadog2.getTags())
      .aggregate();
  }
}
