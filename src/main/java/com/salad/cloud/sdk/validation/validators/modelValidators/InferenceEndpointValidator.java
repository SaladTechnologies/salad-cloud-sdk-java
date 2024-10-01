package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class InferenceEndpointValidator extends AbstractModelValidator<InferenceEndpoint> {

  public InferenceEndpointValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpoint inferenceEndpoint) {
    return new ViolationAggregator()
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .validate(inferenceEndpoint.getDisplayName())
      )
      .aggregate();
  }
}
