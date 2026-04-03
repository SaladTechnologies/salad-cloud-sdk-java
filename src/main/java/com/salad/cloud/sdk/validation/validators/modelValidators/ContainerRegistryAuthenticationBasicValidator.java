package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationBasic;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerRegistryAuthenticationBasic model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationBasicValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationBasic> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationBasicValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationBasicValidator() {}

  /**
   * Validates the ContainerRegistryAuthenticationBasic model's fields and constraints.
   *
   * @param containerRegistryAuthenticationBasic The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationBasic containerRegistryAuthenticationBasic) {
    return new ViolationAggregator()
      .add(
        new StringValidator("password")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationBasic.getPassword())
      )
      .add(
        new StringValidator("username")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationBasic.getUsername())
      )
      .aggregate();
  }
}
