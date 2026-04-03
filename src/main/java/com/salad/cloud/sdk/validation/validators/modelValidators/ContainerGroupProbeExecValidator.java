package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupProbeExec model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupProbeExecValidator extends AbstractModelValidator<ContainerGroupProbeExec> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupProbeExecValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupProbeExecValidator() {}

  /**
   * Validates the ContainerGroupProbeExec model's fields and constraints.
   *
   * @param containerGroupProbeExec The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupProbeExec containerGroupProbeExec) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("command")
          .minLength(1)
          .maxLength(100)
          .itemValidator(new StringValidator().minLength(1).maxLength(2048).pattern("^.*$").required())
          .required()
          .validate(containerGroupProbeExec.getCommand())
      )
      .aggregate();
  }
}
