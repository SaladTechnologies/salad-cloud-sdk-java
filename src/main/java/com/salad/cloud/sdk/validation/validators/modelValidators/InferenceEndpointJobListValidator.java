package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class InferenceEndpointJobListValidator extends AbstractModelValidator<InferenceEndpointJobList> {

  public InferenceEndpointJobListValidator(String fieldName) {
    super(fieldName);
  }

  public InferenceEndpointJobListValidator() {}

  @Override
  protected Violation[] validateModel(InferenceEndpointJobList inferenceEndpointJobList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<InferenceEndpointJob>("items")
          .maxLength(100)
          .itemValidator(new InferenceEndpointJobValidator().required())
          .required()
          .validate(inferenceEndpointJobList.getItems())
      )
      .add(
        new NumericValidator<Long>("page")
          .min(1L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointJobList.getPage())
      )
      .add(
        new NumericValidator<Long>("pageSize")
          .min(1L)
          .max(100L)
          .required()
          .validate(inferenceEndpointJobList.getPageSize())
      )
      .add(
        new NumericValidator<Long>("totalSize")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(inferenceEndpointJobList.getTotalSize())
      )
      .aggregate();
  }
}
