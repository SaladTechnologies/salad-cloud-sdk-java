package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

/**
 * Validator implementation for ContainerLogging model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerLoggingValidator extends AbstractModelValidator<ContainerLogging> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerLoggingValidator() {}

  /**
   * Validates the ContainerLogging model's fields and constraints.
   *
   * @param containerLogging The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerLogging containerLogging) {
    return new ViolationAggregator()
      .add(new AxiomLoggingConfigurationValidator("axiom").optional().validate(containerLogging.getAxiom()))
      .add(new DatadogLoggingConfigurationValidator("datadog").optional().validate(containerLogging.getDatadog()))
      .add(new ContainerLoggingConfigurationHttp1Validator("http").optional().validate(containerLogging.getHttp()))
      .add(new NewRelicLoggingConfigurationValidator("newRelic").optional().validate(containerLogging.getNewRelic()))
      .add(new ContainerLoggingSplunkConfigurationValidator("splunk").optional().validate(containerLogging.getSplunk()))
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(containerLogging.getTcp()))
      .aggregate();
  }
}
