package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerConfigurationValidator extends AbstractModelValidator<ContainerConfiguration> {

  public ContainerConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerConfiguration containerConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("image")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .required()
          .validate(containerConfiguration.getImage())
      )
      .add(
        new CreateContainerResourceRequirementsValidator("resources")
          .required()
          .validate(containerConfiguration.getResources())
      )
      .add(
        new ListValidator<String>("command")
          .maxLength(100)
          .itemValidator(new StringValidator().minLength(1).maxLength(1000).pattern("^.*$").required())
          .optional()
          .validate(containerConfiguration.getCommand())
      )
      .add(
        new ContainerConfigurationLoggingValidator("logging").optional().validate(containerConfiguration.getLogging())
      )
      .add(
        new ContainerRegistryAuthenticationValidator("registryAuthentication")
          .optional()
          .validate(containerConfiguration.getRegistryAuthentication())
      )
      .aggregate();
  }
}
