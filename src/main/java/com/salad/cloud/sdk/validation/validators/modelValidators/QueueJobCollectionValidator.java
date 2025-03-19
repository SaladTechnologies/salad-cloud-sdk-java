package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class QueueJobCollectionValidator extends AbstractModelValidator<QueueJobCollection> {

  public QueueJobCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public QueueJobCollectionValidator() {}

  @Override
  protected Violation[] validateModel(QueueJobCollection queueJobCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<QueueJob>("items")
          .maxLength(100)
          .itemValidator(new QueueJobValidator().required())
          .required()
          .validate(queueJobCollection.getItems())
      )
      .aggregate();
  }
}
