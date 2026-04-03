package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for InferenceEndpointJob model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InferenceEndpointJobValidator extends AbstractModelValidator<InferenceEndpointJob> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InferenceEndpointJobValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InferenceEndpointJobValidator() {}

  /**
   * Validates the InferenceEndpointJob model's fields and constraints.
   *
   * @param inferenceEndpointJob The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InferenceEndpointJob inferenceEndpointJob) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpointJobEvent>("events")
          .maxLength(1000)
          .required()
          .validate(inferenceEndpointJob.getEvents())
      )
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
