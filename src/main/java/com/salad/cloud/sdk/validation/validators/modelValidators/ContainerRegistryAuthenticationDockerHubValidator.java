package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationDockerHub;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerRegistryAuthenticationDockerHubValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationDockerHub> {

  public ContainerRegistryAuthenticationDockerHubValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationDockerHubValidator() {}

  @Override
  protected Violation[] validateModel(
    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub
  ) {
    return new ViolationAggregator()
      .add(
        new StringValidator("username")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationDockerHub.getUsername())
      )
      .add(
        new StringValidator("personalAccessToken")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationDockerHub.getPersonalAccessToken())
      )
      .aggregate();
  }
}
