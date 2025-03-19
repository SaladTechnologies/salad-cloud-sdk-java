package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthentication;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerRegistryAuthenticationValidator extends AbstractModelValidator<ContainerRegistryAuthentication> {

  public ContainerRegistryAuthenticationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerRegistryAuthentication containerRegistryAuthentication) {
    return new ViolationAggregator()
      .add(
        new ContainerRegistryAuthenticationAwsEcrValidator("awsEcr")
          .optional()
          .validate(containerRegistryAuthentication.getAwsEcr())
      )
      .add(
        new ContainerRegistryAuthenticationBasicValidator("basic")
          .optional()
          .validate(containerRegistryAuthentication.getBasic())
      )
      .add(
        new ContainerRegistryAuthenticationDockerHubValidator("dockerHub")
          .optional()
          .validate(containerRegistryAuthentication.getDockerHub())
      )
      .add(
        new ContainerRegistryAuthenticationGcpGarValidator("gcpGar")
          .optional()
          .validate(containerRegistryAuthentication.getGcpGar())
      )
      .add(
        new ContainerRegistryAuthenticationGcpGcrValidator("gcpGcr")
          .optional()
          .validate(containerRegistryAuthentication.getGcpGcr())
      )
      .aggregate();
  }
}
