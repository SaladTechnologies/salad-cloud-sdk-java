package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class InferenceEndpointJobCollectionValidator extends AbstractModelValidator<InferenceEndpointJobCollection> {

  public InferenceEndpointJobCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobCollectionValidator() {}

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
