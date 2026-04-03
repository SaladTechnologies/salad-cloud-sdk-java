package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for InferenceEndpointCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InferenceEndpointCollectionValidator extends AbstractModelValidator<InferenceEndpointCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InferenceEndpointCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InferenceEndpointCollectionValidator() {}

  /**
   * Validates the InferenceEndpointCollection model's fields and constraints.
   *
   * @param inferenceEndpointCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InferenceEndpointCollection inferenceEndpointCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpoint>("items")
          .maxLength(100)
          .itemValidator(new InferenceEndpointValidator().required())
          .required()
          .validate(inferenceEndpointCollection.getItems())
      )
      .add(
        new NumericValidator<Long>("page")
          .min(1L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointCollection.getPage())
      )
      .add(
        new NumericValidator<Long>("pageSize")
          .min(1L)
          .max(100L)
          .required()
          .validate(inferenceEndpointCollection.getPageSize())
      )
      .add(
        new NumericValidator<Long>("totalSize")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointCollection.getTotalSize())
      )
      .aggregate();
  }
}
