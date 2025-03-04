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
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpoint.getName())
      )
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpoint.getOrganizationName())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .required()
          .validate(inferenceEndpoint.getDisplayName())
      )
      .add(
        new StringValidator("description")
          .maxLength(1000)
          .pattern("^[\\P{Cc}\\P{Cn}\\P{Cs}]*$")
          .required()
          .validate(inferenceEndpoint.getDescription())
      )
      .aggregate();
  }
}
