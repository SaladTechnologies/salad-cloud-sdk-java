package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueBasedAutoscalerConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for QueueBasedAutoscalerConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueueBasedAutoscalerConfigurationValidator
  extends AbstractModelValidator<QueueBasedAutoscalerConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueueBasedAutoscalerConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueueBasedAutoscalerConfigurationValidator() {}

  /**
   * Validates the QueueBasedAutoscalerConfiguration model's fields and constraints.
   *
   * @param queueBasedAutoscalerConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(QueueBasedAutoscalerConfiguration queueBasedAutoscalerConfiguration) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("desiredQueueLength")
          .min(1L)
          .max(100L)
          .required()
          .validate(queueBasedAutoscalerConfiguration.getDesiredQueueLength())
      )
      .add(
        new NumericValidator<Long>("maxReplicas")
          .min(1L)
          .max(500L)
          .required()
          .validate(queueBasedAutoscalerConfiguration.getMaxReplicas())
      )
      .add(
        new NumericValidator<Long>("minReplicas")
          .min(0L)
          .max(100L)
          .required()
          .validate(queueBasedAutoscalerConfiguration.getMinReplicas())
      )
      .add(
        new NumericValidator<Long>("maxDownscalePerMinute")
          .min(1L)
          .max(100L)
          .optional()
          .validate(queueBasedAutoscalerConfiguration.getMaxDownscalePerMinute())
      )
      .add(
        new NumericValidator<Long>("maxUpscalePerMinute")
          .min(1L)
          .max(100L)
          .optional()
          .validate(queueBasedAutoscalerConfiguration.getMaxUpscalePerMinute())
      )
      .add(
        new NumericValidator<Long>("pollingPeriod")
          .min(15L)
          .max(1800L)
          .optional()
          .validate(queueBasedAutoscalerConfiguration.getPollingPeriod())
      )
      .aggregate();
  }
}
