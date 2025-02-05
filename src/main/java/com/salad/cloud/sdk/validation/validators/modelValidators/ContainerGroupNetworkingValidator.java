package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupNetworking;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupNetworkingValidator extends AbstractModelValidator<ContainerGroupNetworking> {

  public ContainerGroupNetworkingValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupNetworkingValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupNetworking containerGroupNetworking) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port").min(1L).max(65535L).required().validate(containerGroupNetworking.getPort())
      )
      .add(
        new NumericValidator<Long>("clientRequestTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworking.getClientRequestTimeout())
      )
      .add(
        new NumericValidator<Long>("serverResponseTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworking.getServerResponseTimeout())
      )
      .aggregate();
  }
}
