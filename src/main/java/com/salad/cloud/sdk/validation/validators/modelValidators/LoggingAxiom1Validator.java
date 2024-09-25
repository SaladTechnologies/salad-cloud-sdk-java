package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingAxiom1;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingAxiom1Validator extends AbstractModelValidator<LoggingAxiom1> {

  public LoggingAxiom1Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingAxiom1Validator() {}

  @Override
  protected Violation[] validateModel(LoggingAxiom1 loggingAxiom1) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingAxiom1.getHost())
      .add(new StringValidator("apiToken").minLength(1).maxLength(1000), loggingAxiom1.getApiToken())
      .add(new StringValidator("dataset").minLength(1).maxLength(1000), loggingAxiom1.getDataset())
      .aggregate();
  }
}
