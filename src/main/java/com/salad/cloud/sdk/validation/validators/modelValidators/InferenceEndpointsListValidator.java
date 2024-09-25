package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointsList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class InferenceEndpointsListValidator extends AbstractModelValidator<InferenceEndpointsList> {

  public InferenceEndpointsListValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointsListValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointsList inferenceEndpointsList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpoint>("items").maxLength(100).itemValidator(new InferenceEndpointValidator()),
        inferenceEndpointsList.getItems()
      )
      .aggregate();
  }
}
