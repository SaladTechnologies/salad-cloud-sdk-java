package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class QueueJobValidator extends AbstractModelValidator<QueueJob> {

  public QueueJobValidator(String fieldName) {
    super(fieldName);
  }

  public QueueJobValidator() {}

  @Override
  protected Violation[] validateModel(QueueJob queueJob) {
    return new ViolationAggregator()
      .add(new ListValidator<QueueJobEvent>("events").maxLength(1000).required().validate(queueJob.getEvents()))
      .add(
        new StringValidator("webhook")
          .minLength(20)
          .maxLength(27)
          .pattern("^\\\\d{4}-\\\\d{2}-\\\\d{2}T\\\\d{2}:\\\\d{2}:\\\\d{2}(\\\\.\\\\d+)?(Z|[+-]\\\\d{2}:\\\\d{2})$")
          .optional()
          .validate(queueJob.getWebhook())
      )
      .aggregate();
  }
}
