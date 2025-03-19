package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class InferenceEndpointJobValidator extends AbstractModelValidator<InferenceEndpointJob> {

  public InferenceEndpointJobValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointJob inferenceEndpointJob) {
    return new ViolationAggregator()
      .add(
        new StringValidator("inferenceEndpointName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointJob.getInferenceEndpointName())
      )
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(inferenceEndpointJob.getOrganizationName())
      )
      .add(
        new ListValidator<InferenceEndpointJobEvent>("events")
          .maxLength(1000)
          .required()
          .validate(inferenceEndpointJob.getEvents())
      )
      .add(
        new StringValidator("webhook")
          .minLength(1)
          .maxLength(2048)
          .optional()
          .validate(inferenceEndpointJob.getWebhook())
      )
      .add(
        new StringValidator("webhookUrl")
          .minLength(1)
          .maxLength(2048)
          .optional()
          .validate(inferenceEndpointJob.getWebhookUrl())
      )
      .aggregate();
  }
}
