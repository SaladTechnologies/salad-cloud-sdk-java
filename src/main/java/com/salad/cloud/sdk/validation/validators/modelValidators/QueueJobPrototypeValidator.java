package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJobPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class QueueJobPrototypeValidator extends AbstractModelValidator<QueueJobPrototype> {

  public QueueJobPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  public QueueJobPrototypeValidator() {}

  @Override
  protected Violation[] validateModel(QueueJobPrototype queueJobPrototype) {
    return new ViolationAggregator()
      .add(
        new StringValidator("webhook")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .optional()
          .validate(queueJobPrototype.getWebhook())
      )
      .aggregate();
  }
}
