package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainerGroupNetworking;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class CreateContainerGroupNetworkingValidator extends AbstractModelValidator<CreateContainerGroupNetworking> {

  public CreateContainerGroupNetworkingValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerGroupNetworkingValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainerGroupNetworking createContainerGroupNetworking) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(createContainerGroupNetworking.getPort())
      )
      .add(
        new NumericValidator<Long>("clientRequestTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(createContainerGroupNetworking.getClientRequestTimeout())
      )
      .add(
        new NumericValidator<Long>("serverResponseTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(createContainerGroupNetworking.getServerResponseTimeout())
      )
      .aggregate();
  }
}
