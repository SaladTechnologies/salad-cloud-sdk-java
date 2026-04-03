package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationDockerHub;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerRegistryAuthenticationDockerHub model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationDockerHubValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationDockerHub> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationDockerHubValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationDockerHubValidator() {}

  /**
   * Validates the ContainerRegistryAuthenticationDockerHub model's fields and constraints.
   *
   * @param containerRegistryAuthenticationDockerHub The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(
    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub
  ) {
    return new ViolationAggregator()
      .add(
        new StringValidator("personalAccessToken")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationDockerHub.getPersonalAccessToken())
      )
      .add(
        new StringValidator("username")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationDockerHub.getUsername())
      )
      .aggregate();
  }
}
