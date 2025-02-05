package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueAutoscaler;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class QueueAutoscalerValidator extends AbstractModelValidator<QueueAutoscaler> {

  public QueueAutoscalerValidator(String fieldName) {
    super(fieldName);
  }

  public QueueAutoscalerValidator() {}

  @Override
  protected Violation[] validateModel(QueueAutoscaler queueAutoscaler) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("minReplicas")
          .min(0L)
          .max(100L)
          .required()
          .validate(queueAutoscaler.getMinReplicas())
      )
      .add(
        new NumericValidator<Long>("maxReplicas")
          .min(1L)
          .max(250L)
          .required()
          .validate(queueAutoscaler.getMaxReplicas())
      )
      .add(
        new NumericValidator<Long>("desiredQueueLength")
          .min(1L)
          .max(100L)
          .required()
          .validate(queueAutoscaler.getDesiredQueueLength())
      )
      .add(
        new NumericValidator<Long>("pollingPeriod")
          .min(15L)
          .max(1800L)
          .optional()
          .validate(queueAutoscaler.getPollingPeriod())
      )
      .add(
        new NumericValidator<Long>("maxUpscalePerMinute")
          .min(1L)
          .max(100L)
          .optional()
          .validate(queueAutoscaler.getMaxUpscalePerMinute())
      )
      .add(
        new NumericValidator<Long>("maxDownscalePerMinute")
          .min(1L)
          .max(100L)
          .optional()
          .validate(queueAutoscaler.getMaxDownscalePerMinute())
      )
      .aggregate();
  }
}
