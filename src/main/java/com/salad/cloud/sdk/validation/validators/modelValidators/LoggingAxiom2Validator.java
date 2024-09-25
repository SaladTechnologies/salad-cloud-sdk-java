package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingAxiom2;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingAxiom2Validator extends AbstractModelValidator<LoggingAxiom2> {

  public LoggingAxiom2Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingAxiom2Validator() {}

  @Override
  protected Violation[] validateModel(LoggingAxiom2 loggingAxiom2) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingAxiom2.getHost())
      .add(new StringValidator("apiToken").minLength(1).maxLength(1000), loggingAxiom2.getApiToken())
      .add(new StringValidator("dataset").minLength(1).maxLength(1000), loggingAxiom2.getDataset())
      .aggregate();
  }
}
