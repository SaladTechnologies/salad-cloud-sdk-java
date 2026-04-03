package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerConfigurationValidator extends AbstractModelValidator<ContainerConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerConfigurationValidator() {}

  /**
   * Validates the ContainerConfiguration model's fields and constraints.
   *
   * @param containerConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
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
