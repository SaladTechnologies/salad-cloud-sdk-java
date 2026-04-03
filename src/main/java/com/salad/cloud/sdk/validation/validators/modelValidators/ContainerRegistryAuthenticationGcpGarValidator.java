package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGar;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerRegistryAuthenticationGcpGar model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationGcpGarValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationGcpGar> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationGcpGarValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationGcpGarValidator() {}

  /**
   * Validates the ContainerRegistryAuthenticationGcpGar model's fields and constraints.
   *
   * @param containerRegistryAuthenticationGcpGar The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationGcpGar containerRegistryAuthenticationGcpGar) {
    return new ViolationAggregator()
      .add(
        new StringValidator("serviceKey")
          .minLength(1)
          .maxLength(10000)
          .required()
          .validate(containerRegistryAuthenticationGcpGar.getServiceKey())
      )
      .aggregate();
  }
}
