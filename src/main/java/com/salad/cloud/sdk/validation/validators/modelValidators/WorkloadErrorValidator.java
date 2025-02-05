package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.WorkloadError;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class WorkloadErrorValidator extends AbstractModelValidator<WorkloadError> {

  public WorkloadErrorValidator(String fieldName) {
    super(fieldName);
  }

  public WorkloadErrorValidator() {}

  @Override
  protected Violation[] validateModel(WorkloadError workloadError) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("version").min(1L).required().validate(workloadError.getVersion()))
      .aggregate();
  }
}
