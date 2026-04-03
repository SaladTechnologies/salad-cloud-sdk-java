package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthentication;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

/**
 * Validator implementation for ContainerRegistryAuthentication model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationValidator extends AbstractModelValidator<ContainerRegistryAuthentication> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationValidator() {}

  /**
   * Validates the ContainerRegistryAuthentication model's fields and constraints.
   *
   * @param containerRegistryAuthentication The model instance to validate
   * @return Array of violations found during validation
   */
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
