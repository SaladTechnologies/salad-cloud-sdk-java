package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerLoggingHttpHeader model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerLoggingHttpHeaderValidator extends AbstractModelValidator<ContainerLoggingHttpHeader> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerLoggingHttpHeaderValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerLoggingHttpHeaderValidator() {}

  /**
   * Validates the ContainerLoggingHttpHeader model's fields and constraints.
   *
   * @param containerLoggingHttpHeader The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerLoggingHttpHeader containerLoggingHttpHeader) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingHttpHeader.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingHttpHeader.getValue())
      )
      .aggregate();
  }
}
