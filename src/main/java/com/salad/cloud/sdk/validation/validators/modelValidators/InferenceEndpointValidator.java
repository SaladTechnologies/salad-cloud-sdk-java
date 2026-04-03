package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for InferenceEndpoint model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InferenceEndpointValidator extends AbstractModelValidator<InferenceEndpoint> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InferenceEndpointValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InferenceEndpointValidator() {}

  /**
   * Validates the InferenceEndpoint model's fields and constraints.
   *
   * @param inferenceEndpoint The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InferenceEndpoint inferenceEndpoint) {
    return new ViolationAggregator()
      .add(
        new StringValidator("description")
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getDescription())
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
        new StringValidator("iconUrl")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getIconUrl())
      )
      .add(
        new StringValidator("inputSchema")
          .minLength(1)
          .maxLength(100000)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getInputSchema())
      )
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
        new StringValidator("outputSchema")
          .minLength(1)
          .maxLength(100000)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getOutputSchema())
      )
      .add(
        new StringValidator("priceDescription")
          .minLength(1)
          .maxLength(100)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getPriceDescription())
      )
      .add(
        new StringValidator("readme")
          .minLength(1)
          .maxLength(100000)
          .pattern("^.*$")
          .required()
          .validate(inferenceEndpoint.getReadme())
      )
      .aggregate();
  }
}
