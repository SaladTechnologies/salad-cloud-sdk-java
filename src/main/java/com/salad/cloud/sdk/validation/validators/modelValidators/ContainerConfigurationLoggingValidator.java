package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerConfigurationLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

/**
 * Validator implementation for ContainerConfigurationLogging model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerConfigurationLoggingValidator extends AbstractModelValidator<ContainerConfigurationLogging> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerConfigurationLoggingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerConfigurationLoggingValidator() {}

  /**
   * Validates the ContainerConfigurationLogging model's fields and constraints.
   *
   * @param containerConfigurationLogging The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerConfigurationLogging containerConfigurationLogging) {
    return new ViolationAggregator()
      .add(
        new AxiomLoggingConfigurationValidator("axiom").optional().validate(containerConfigurationLogging.getAxiom())
      )
      .add(
        new DatadogLoggingConfigurationValidator("datadog")
          .optional()
          .validate(containerConfigurationLogging.getDatadog())
      )
      .add(
        new ContainerLoggingConfigurationHttp2Validator("http")
          .optional()
          .validate(containerConfigurationLogging.getHttp())
      )
      .add(
        new NewRelicLoggingConfigurationValidator("newRelic")
          .optional()
          .validate(containerConfigurationLogging.getNewRelic())
      )
      .add(
        new ContainerLoggingSplunkConfigurationValidator("splunk")
          .optional()
          .validate(containerConfigurationLogging.getSplunk())
      )
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(containerConfigurationLogging.getTcp()))
      .aggregate();
  }
}
