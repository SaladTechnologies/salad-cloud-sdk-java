package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.WorkloadError;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class WorkloadErrorValidator extends AbstractModelValidator<WorkloadError> {

  public WorkloadErrorValidator(String fieldName) {
    super(fieldName);
  }

  public WorkloadErrorValidator() {}

  @Override
  protected Violation[] validateModel(WorkloadError workloadError) {
    return new ViolationAggregator()
      .add(
        new StringValidator("detail")
          .minLength(1)
          .maxLength(255)
          .pattern("^.*$")
          .required()
          .validate(workloadError.getDetail())
      )
      .add(
        new NumericValidator<Long>("version").min(1L).max(2147483647L).required().validate(workloadError.getVersion())
      )
      .aggregate();
  }
}
