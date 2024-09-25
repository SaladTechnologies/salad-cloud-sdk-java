package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class InferenceEndpointJobValidator extends AbstractModelValidator<InferenceEndpointJob> {

  public InferenceEndpointJobValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointJob inferenceEndpointJob) {
    return new ViolationAggregator()
      .add(new ListValidator<InferenceEndpointJobEvent>("events").maxLength(1000), inferenceEndpointJob.getEvents())
      .aggregate();
  }
}
