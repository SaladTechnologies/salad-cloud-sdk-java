package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for InferenceEndpointJobCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InferenceEndpointJobCollectionValidator extends AbstractModelValidator<InferenceEndpointJobCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InferenceEndpointJobCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InferenceEndpointJobCollectionValidator() {}

  /**
   * Validates the InferenceEndpointJobCollection model's fields and constraints.
   *
   * @param inferenceEndpointJobCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InferenceEndpointJobCollection inferenceEndpointJobCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpointJob>("items")
          .maxLength(100)
          .itemValidator(new InferenceEndpointJobValidator().required())
          .required()
          .validate(inferenceEndpointJobCollection.getItems())
      )
      .add(
        new NumericValidator<Long>("page")
          .min(1L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointJobCollection.getPage())
      )
      .add(
        new NumericValidator<Long>("pageSize")
          .min(1L)
          .max(100L)
          .required()
          .validate(inferenceEndpointJobCollection.getPageSize())
      )
      .add(
        new NumericValidator<Long>("totalSize")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointJobCollection.getTotalSize())
      )
      .aggregate();
  }
}
