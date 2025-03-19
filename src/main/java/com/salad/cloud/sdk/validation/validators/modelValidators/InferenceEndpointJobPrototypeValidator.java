package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJobPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class InferenceEndpointJobPrototypeValidator extends AbstractModelValidator<InferenceEndpointJobPrototype> {

  public InferenceEndpointJobPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobPrototypeValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointJobPrototype inferenceEndpointJobPrototype) {
    return new ViolationAggregator()
      .add(
        new StringValidator("webhook")
          .minLength(1)
          .maxLength(2048)
          .optional()
          .validate(inferenceEndpointJobPrototype.getWebhook())
      )
      .add(
        new StringValidator("webhookUrl")
          .minLength(1)
          .maxLength(2048)
          .optional()
          .validate(inferenceEndpointJobPrototype.getWebhookUrl())
      )
      .aggregate();
  }
}
