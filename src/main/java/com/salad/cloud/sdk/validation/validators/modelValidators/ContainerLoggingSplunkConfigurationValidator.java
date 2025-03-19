package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingSplunkConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerLoggingSplunkConfigurationValidator
  extends AbstractModelValidator<ContainerLoggingSplunkConfiguration> {

  public ContainerLoggingSplunkConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingSplunkConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingSplunkConfiguration.getHost())
      )
      .add(
        new StringValidator("token")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingSplunkConfiguration.getToken())
      )
      .aggregate();
  }
}
