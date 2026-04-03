package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupLivenessProbe model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupLivenessProbeValidator extends AbstractModelValidator<ContainerGroupLivenessProbe> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupLivenessProbeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupLivenessProbeValidator() {}

  /**
   * Validates the ContainerGroupLivenessProbe model's fields and constraints.
   *
   * @param containerGroupLivenessProbe The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupLivenessProbe containerGroupLivenessProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .max(20L)
          .required()
          .validate(containerGroupLivenessProbe.getFailureThreshold())
      )
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .max(1200L)
          .required()
          .validate(containerGroupLivenessProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .max(120L)
          .required()
          .validate(containerGroupLivenessProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .max(10L)
          .required()
          .validate(containerGroupLivenessProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .max(60L)
          .required()
          .validate(containerGroupLivenessProbe.getTimeoutSeconds())
      )
      .add(new ContainerGroupProbeExecValidator("exec").optional().validate(containerGroupLivenessProbe.getExec()))
      .add(new ContainerGroupGRpcProbeValidator("grpc").optional().validate(containerGroupLivenessProbe.getGrpc()))
      .add(
        new ContainerGroupHttpProbeConfigurationValidator("http")
          .optional()
          .validate(containerGroupLivenessProbe.getHttp())
      )
      .add(new ContainerGroupTcpProbeValidator("tcp").optional().validate(containerGroupLivenessProbe.getTcp()))
      .aggregate();
  }
}
