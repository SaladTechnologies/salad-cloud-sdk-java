package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpoint;
import com.salad.cloud.sdk.models.InferenceEndpointList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class InferenceEndpointListValidator extends AbstractModelValidator<InferenceEndpointList> {

  public InferenceEndpointListValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointListValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointList inferenceEndpointList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpoint>("items")
          .maxLength(100)
          .itemValidator(new InferenceEndpointValidator().required())
          .required()
          .validate(inferenceEndpointList.getItems())
      )
      .add(
        new NumericValidator<Long>("page").min(1L).max(2147483647L).required().validate(inferenceEndpointList.getPage())
      )
      .add(
        new NumericValidator<Long>("pageSize")
          .min(1L)
          .max(100L)
          .required()
          .validate(inferenceEndpointList.getPageSize())
      )
      .add(
        new NumericValidator<Long>("totalSize")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointList.getTotalSize())
      )
      .aggregate();
  }
}
