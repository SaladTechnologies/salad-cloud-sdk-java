package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupProbeHttpHeader model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupProbeHttpHeaderValidator extends AbstractModelValidator<ContainerGroupProbeHttpHeader> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupProbeHttpHeaderValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupProbeHttpHeaderValidator() {}

  /**
   * Validates the ContainerGroupProbeHttpHeader model's fields and constraints.
   *
   * @param containerGroupProbeHttpHeader The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupProbeHttpHeader containerGroupProbeHttpHeader) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(256)
          .pattern("^.*$")
          .required()
          .validate(containerGroupProbeHttpHeader.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1024)
          .pattern("^.*$")
          .required()
          .validate(containerGroupProbeHttpHeader.getValue())
      )
      .aggregate();
  }
}
