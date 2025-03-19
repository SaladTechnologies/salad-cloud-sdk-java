package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class InferenceEndpointCollectionValidator extends AbstractModelValidator<InferenceEndpointCollection> {

  public InferenceEndpointCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointCollectionValidator() {}

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
