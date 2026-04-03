package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupReadinessProbe model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupReadinessProbeValidator extends AbstractModelValidator<ContainerGroupReadinessProbe> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupReadinessProbeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupReadinessProbeValidator() {}

  /**
   * Validates the ContainerGroupReadinessProbe model's fields and constraints.
   *
   * @param containerGroupReadinessProbe The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupReadinessProbe containerGroupReadinessProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .max(20L)
          .required()
          .validate(containerGroupReadinessProbe.getFailureThreshold())
      )
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .max(1200L)
          .required()
          .validate(containerGroupReadinessProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .max(120L)
          .required()
          .validate(containerGroupReadinessProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .max(10L)
          .required()
          .validate(containerGroupReadinessProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .max(60L)
          .required()
          .validate(containerGroupReadinessProbe.getTimeoutSeconds())
      )
      .add(new ContainerGroupProbeExecValidator("exec").optional().validate(containerGroupReadinessProbe.getExec()))
      .add(new ContainerGroupGRpcProbeValidator("grpc").optional().validate(containerGroupReadinessProbe.getGrpc()))
      .add(
        new ContainerGroupHttpProbeConfigurationValidator("http")
          .optional()
          .validate(containerGroupReadinessProbe.getHttp())
      )
      .add(new ContainerGroupTcpProbeValidator("tcp").optional().validate(containerGroupReadinessProbe.getTcp()))
      .aggregate();
  }
}
