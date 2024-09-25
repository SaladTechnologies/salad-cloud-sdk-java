package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class QueueJobValidator extends AbstractModelValidator<QueueJob> {

  public QueueJobValidator(String fieldName) {
    super(fieldName);
  }

  public QueueJobValidator() {}

  @Override
  protected Violation[] validateModel(QueueJob queueJob) {
    return new ViolationAggregator()
      .add(new ListValidator<QueueJobEvent>("events").maxLength(1000), queueJob.getEvents())
      .aggregate();
  }
}
