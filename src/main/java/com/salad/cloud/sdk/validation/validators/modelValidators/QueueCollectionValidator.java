package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueueCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class QueueCollectionValidator extends AbstractModelValidator<QueueCollection> {

  public QueueCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public QueueCollectionValidator() {}

  @Override
  protected Violation[] validateModel(QueueCollection queueCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<Queue>("items")
          .maxLength(100)
          .itemValidator(new QueueValidator().required())
          .required()
          .validate(queueCollection.getItems())
      )
      .aggregate();
  }
}
