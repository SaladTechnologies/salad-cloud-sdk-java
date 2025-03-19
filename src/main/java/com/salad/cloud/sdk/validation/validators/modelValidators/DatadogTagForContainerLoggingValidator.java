package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class DatadogTagForContainerLoggingValidator extends AbstractModelValidator<DatadogTagForContainerLogging> {

  public DatadogTagForContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public DatadogTagForContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(DatadogTagForContainerLogging datadogTagForContainerLogging) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogTagForContainerLogging.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogTagForContainerLogging.getValue())
      )
      .aggregate();
  }
}
