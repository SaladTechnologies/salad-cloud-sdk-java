package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJobPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for InferenceEndpointJobPrototype model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InferenceEndpointJobPrototypeValidator extends AbstractModelValidator<InferenceEndpointJobPrototype> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InferenceEndpointJobPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InferenceEndpointJobPrototypeValidator() {}

  /**
   * Validates the InferenceEndpointJobPrototype model's fields and constraints.
   *
   * @param inferenceEndpointJobPrototype The model instance to validate
   * @return Array of violations found during validation
   */
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
