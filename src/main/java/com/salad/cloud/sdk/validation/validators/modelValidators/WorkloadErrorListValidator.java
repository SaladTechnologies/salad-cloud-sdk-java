package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.WorkloadError;
import com.salad.cloud.sdk.models.WorkloadErrorList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class WorkloadErrorListValidator extends AbstractModelValidator<WorkloadErrorList> {

  public WorkloadErrorListValidator(String fieldName) {
    super(fieldName);
  }

  public WorkloadErrorListValidator() {}

  @Override
  protected Violation[] validateModel(WorkloadErrorList workloadErrorList) {
    return new ViolationAggregator()
      .add(new ListValidator<WorkloadError>("items").maxLength(50), workloadErrorList.getItems())
      .aggregate();
  }
}
