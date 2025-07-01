package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntryResource;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LogEntryResourceValidator extends AbstractModelValidator<LogEntryResource> {

  public LogEntryResourceValidator(String fieldName) {
    super(fieldName);
  }

  public LogEntryResourceValidator() {}

  @Override
  protected Violation[] validateModel(LogEntryResource logEntryResource) {
    return new ViolationAggregator()
      .add(new StringValidator("type").minLength(1).maxLength(1000).required().validate(logEntryResource.getType()))
      .aggregate();
  }
}
