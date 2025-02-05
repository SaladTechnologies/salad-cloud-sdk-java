package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainerGroupNetworking;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class UpdateContainerGroupNetworkingValidator extends AbstractModelValidator<UpdateContainerGroupNetworking> {

  public UpdateContainerGroupNetworkingValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateContainerGroupNetworkingValidator() {}

  @Override
  protected Violation[] validateModel(UpdateContainerGroupNetworking updateContainerGroupNetworking) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .optional()
          .validate(updateContainerGroupNetworking.getPort())
      )
      .aggregate();
  }
}
