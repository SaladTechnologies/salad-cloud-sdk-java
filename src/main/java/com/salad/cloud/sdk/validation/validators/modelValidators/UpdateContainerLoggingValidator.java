package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

/**
 * Validator implementation for UpdateContainerLogging model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class UpdateContainerLoggingValidator extends AbstractModelValidator<UpdateContainerLogging> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public UpdateContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public UpdateContainerLoggingValidator() {}

  /**
   * Validates the UpdateContainerLogging model's fields and constraints.
   *
   * @param updateContainerLogging The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(UpdateContainerLogging updateContainerLogging) {
    return new ViolationAggregator()
      .add(new AxiomLoggingConfigurationValidator("axiom").optional().validate(updateContainerLogging.getAxiom()))
      .add(new DatadogLoggingConfigurationValidator("datadog").optional().validate(updateContainerLogging.getDatadog()))
      .add(
        new ContainerLoggingConfigurationHttp1Validator("http").optional().validate(updateContainerLogging.getHttp())
      )
      .add(
        new NewRelicLoggingConfigurationValidator("newRelic").optional().validate(updateContainerLogging.getNewRelic())
      )
      .add(
        new ContainerLoggingSplunkConfigurationValidator("splunk")
          .optional()
          .validate(updateContainerLogging.getSplunk())
      )
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(updateContainerLogging.getTcp()))
      .aggregate();
  }
}
