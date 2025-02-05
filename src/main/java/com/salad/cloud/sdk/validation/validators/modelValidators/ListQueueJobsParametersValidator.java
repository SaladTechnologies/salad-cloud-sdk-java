package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ListQueueJobsParameters;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ListQueueJobsParametersValidator extends AbstractModelValidator<ListQueueJobsParameters> {

  public ListQueueJobsParametersValidator(String fieldName) {
    super(fieldName);
  }

  public ListQueueJobsParametersValidator() {}

  @Override
  protected Violation[] validateModel(ListQueueJobsParameters requestParameters) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("page").min(1L).max(2147483647L).optional().validate(requestParameters.getPage()))
      .add(
        new NumericValidator<Long>("pageSize").min(1L).max(100L).optional().validate(requestParameters.getPageSize())
      )
      .aggregate();
  }
}
