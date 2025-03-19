package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupNetworkingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupNetworkingConfigurationValidator
  extends AbstractModelValidator<ContainerGroupNetworkingConfiguration> {

  public ContainerGroupNetworkingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupNetworkingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupNetworkingConfiguration containerGroupNetworkingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("dns")
          .minLength(1)
          .maxLength(253)
          .pattern("^([a-z][a-z0-9-]{0,61}[a-z0-9]\\.)*[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroupNetworkingConfiguration.getDns())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerGroupNetworkingConfiguration.getPort())
      )
      .add(
        new NumericValidator<Long>("clientRequestTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworkingConfiguration.getClientRequestTimeout())
      )
      .add(
        new NumericValidator<Long>("serverResponseTimeout")
          .min(1L)
          .max(100000L)
          .optional()
          .validate(containerGroupNetworkingConfiguration.getServerResponseTimeout())
      )
      .aggregate();
  }
}
