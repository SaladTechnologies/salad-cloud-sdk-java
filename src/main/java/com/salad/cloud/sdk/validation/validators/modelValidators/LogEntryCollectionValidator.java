package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntry;
import com.salad.cloud.sdk.models.LogEntryCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LogEntryCollectionValidator extends AbstractModelValidator<LogEntryCollection> {

  public LogEntryCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public LogEntryCollectionValidator() {}

  @Override
  protected Violation[] validateModel(LogEntryCollection logEntryCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<LogEntry>("items")
          .maxLength(10000)
          .itemValidator(new LogEntryValidator().required())
          .required()
          .validate(logEntryCollection.getItems())
      )
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(logEntryCollection.getOrganizationName())
      )
      .aggregate();
  }
}
