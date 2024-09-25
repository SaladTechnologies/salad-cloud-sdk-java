package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LoggingAxiom3;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LoggingAxiom3Validator extends AbstractModelValidator<LoggingAxiom3> {

  public LoggingAxiom3Validator(String fieldName) {
    super(fieldName);
  }

  public LoggingAxiom3Validator() {}

  @Override
  protected Violation[] validateModel(LoggingAxiom3 loggingAxiom3) {
    return new ViolationAggregator()
      .add(new StringValidator("host").minLength(1).maxLength(1000), loggingAxiom3.getHost())
      .add(new StringValidator("apiToken").minLength(1).maxLength(1000), loggingAxiom3.getApiToken())
      .add(new StringValidator("dataset").minLength(1).maxLength(1000), loggingAxiom3.getDataset())
      .aggregate();
  }
}
