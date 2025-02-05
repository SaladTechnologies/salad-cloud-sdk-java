package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GetInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class GetInferenceEndpointJobsParametersValidator
  extends AbstractModelValidator<GetInferenceEndpointJobsParameters> {

  public GetInferenceEndpointJobsParametersValidator(String fieldName) {
    super(fieldName);
  }

  public GetInferenceEndpointJobsParametersValidator() {}

  @Override
  protected Violation[] validateModel(GetInferenceEndpointJobsParameters requestParameters) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("page").min(1L).max(2147483647L).optional().validate(requestParameters.getPage()))
      .add(
        new NumericValidator<Long>("pageSize").min(1L).max(100L).optional().validate(requestParameters.getPageSize())
      )
      .aggregate();
  }
}
