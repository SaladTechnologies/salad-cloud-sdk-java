package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueBasedAutoscalerConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class QueueBasedAutoscalerConfigurationValidator
  extends AbstractModelValidator<QueueBasedAutoscalerConfiguration> {

  public QueueBasedAutoscalerConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public QueueBasedAutoscalerConfigurationValidator() {}

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
