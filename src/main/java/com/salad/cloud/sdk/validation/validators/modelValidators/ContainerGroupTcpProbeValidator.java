package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupTcpProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupTcpProbe model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupTcpProbeValidator extends AbstractModelValidator<ContainerGroupTcpProbe> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupTcpProbeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupTcpProbeValidator() {}

  /**
   * Validates the ContainerGroupTcpProbe model's fields and constraints.
   *
   * @param containerGroupTcpProbe The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupTcpProbe containerGroupTcpProbe) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("port").min(0L).max(65535L).required().validate(containerGroupTcpProbe.getPort()))
      .aggregate();
  }
}
