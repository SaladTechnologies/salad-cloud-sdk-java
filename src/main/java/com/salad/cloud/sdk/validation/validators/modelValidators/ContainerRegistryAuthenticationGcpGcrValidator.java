package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGcr;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerRegistryAuthenticationGcpGcr model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerRegistryAuthenticationGcpGcrValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationGcpGcr> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerRegistryAuthenticationGcpGcrValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerRegistryAuthenticationGcpGcrValidator() {}

  /**
   * Validates the ContainerRegistryAuthenticationGcpGcr model's fields and constraints.
   *
   * @param containerRegistryAuthenticationGcpGcr The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationGcpGcr containerRegistryAuthenticationGcpGcr) {
    return new ViolationAggregator()
      .add(
        new StringValidator("serviceKey")
          .minLength(1)
          .maxLength(10000)
          .required()
          .validate(containerRegistryAuthenticationGcpGcr.getServiceKey())
      )
      .aggregate();
  }
}
