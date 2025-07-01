package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.LogEntryQuery;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class LogEntryQueryValidator extends AbstractModelValidator<LogEntryQuery> {

  public LogEntryQueryValidator(String fieldName) {
    super(fieldName);
  }

  public LogEntryQueryValidator() {}

  @Override
  protected Violation[] validateModel(LogEntryQuery logEntryQuery) {
    return new ViolationAggregator()
      .add(new StringValidator("query").maxLength(20000).required().validate(logEntryQuery.getQuery()))
      .add(new NumericValidator<Long>("pageSize").min(1L).max(100L).optional().validate(logEntryQuery.getPageSize()))
      .aggregate();
  }
}
