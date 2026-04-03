package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationAwsEcr;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerRegistryAuthenticationAwsEcr model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationAwsEcrValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationAwsEcr> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationAwsEcrValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationAwsEcrValidator() {}

  /**
   * Validates the ContainerRegistryAuthenticationAwsEcr model's fields and constraints.
   *
   * @param containerRegistryAuthenticationAwsEcr The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationAwsEcr containerRegistryAuthenticationAwsEcr) {
    return new ViolationAggregator()
      .add(
        new StringValidator("accessKeyId")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationAwsEcr.getAccessKeyId())
      )
      .add(
        new StringValidator("secretAccessKey")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationAwsEcr.getSecretAccessKey())
      )
      .aggregate();
  }
}
