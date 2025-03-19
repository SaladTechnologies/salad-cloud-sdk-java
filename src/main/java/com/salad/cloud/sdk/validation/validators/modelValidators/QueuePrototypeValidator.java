package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueuePrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class QueuePrototypeValidator extends AbstractModelValidator<QueuePrototype> {

  public QueuePrototypeValidator(String fieldName) {
    super(fieldName);
  }

  public QueuePrototypeValidator() {}

  @Override
  protected Violation[] validateModel(QueuePrototype queuePrototype) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queuePrototype.getName())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(queuePrototype.getDisplayName())
      )
      .add(
        new StringValidator("description")
          .maxLength(500)
          .pattern("^.*$")
          .optional()
          .validate(queuePrototype.getDescription())
      )
      .aggregate();
  }
}
