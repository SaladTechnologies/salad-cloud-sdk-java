package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupStartupProbe model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupStartupProbeValidator extends AbstractModelValidator<ContainerGroupStartupProbe> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupStartupProbeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupStartupProbeValidator() {}

  /**
   * Validates the ContainerGroupStartupProbe model's fields and constraints.
   *
   * @param containerGroupStartupProbe The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupStartupProbe containerGroupStartupProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .max(20L)
          .required()
          .validate(containerGroupStartupProbe.getFailureThreshold())
      )
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .max(1200L)
          .required()
          .validate(containerGroupStartupProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .max(120L)
          .required()
          .validate(containerGroupStartupProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .max(10L)
          .required()
          .validate(containerGroupStartupProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .max(60L)
          .required()
          .validate(containerGroupStartupProbe.getTimeoutSeconds())
      )
      .add(new ContainerGroupProbeExecValidator("exec").optional().validate(containerGroupStartupProbe.getExec()))
      .add(new ContainerGroupGRpcProbeValidator("grpc").optional().validate(containerGroupStartupProbe.getGrpc()))
      .add(
        new ContainerGroupHttpProbeConfigurationValidator("http")
          .optional()
          .validate(containerGroupStartupProbe.getHttp())
      )
      .add(new ContainerGroupTcpProbeValidator("tcp").optional().validate(containerGroupStartupProbe.getTcp()))
      .aggregate();
  }
}
