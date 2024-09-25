package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueueList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class QueueListValidator extends AbstractModelValidator<QueueList> {

  public QueueListValidator(String fieldName) {
    super(fieldName);
  }

  public QueueListValidator() {}

  @Override
  protected Violation[] validateModel(QueueList queueList) {
    return new ViolationAggregator()
      .add(new ListValidator<Queue>("items").maxLength(100).itemValidator(new QueueValidator()), queueList.getItems())
      .aggregate();
  }
}
