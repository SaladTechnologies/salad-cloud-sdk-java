package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class InferenceEndpointJobListValidator extends AbstractModelValidator<InferenceEndpointJobList> {

  public InferenceEndpointJobListValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobListValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointJobList inferenceEndpointJobList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpointJob>("items")
          .maxLength(100)
          .itemValidator(new InferenceEndpointJobValidator()),
        inferenceEndpointJobList.getItems()
      )
      .aggregate();
  }
}
