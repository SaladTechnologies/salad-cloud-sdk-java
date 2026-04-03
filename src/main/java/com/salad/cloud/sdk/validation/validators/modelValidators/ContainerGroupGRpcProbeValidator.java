package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupGRpcProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupGRpcProbe model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupGRpcProbeValidator extends AbstractModelValidator<ContainerGroupGRpcProbe> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupGRpcProbeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupGRpcProbeValidator() {}

  /**
   * Validates the ContainerGroupGRpcProbe model's fields and constraints.
   *
   * @param containerGroupGRpcProbe The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupGRpcProbe containerGroupGRpcProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("port").min(0L).max(65536L).required().validate(containerGroupGRpcProbe.getPort())
      )
      .add(
        new StringValidator("service")
          .maxLength(1024)
          .pattern("^.*$")
          .required()
          .validate(containerGroupGRpcProbe.getService())
      )
      .aggregate();
  }
}
