package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class QueueJobListValidator extends AbstractModelValidator<QueueJobList> {

  public QueueJobListValidator(String fieldName) {
    super(fieldName);
  }

  public QueueJobListValidator() {}

  @Override
  protected Violation[] validateModel(QueueJobList queueJobList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<QueueJob>("items")
          .maxLength(100)
          .itemValidator(new QueueJobValidator())
          .validate(queueJobList.getItems())
      )
      .aggregate();
  }
}
