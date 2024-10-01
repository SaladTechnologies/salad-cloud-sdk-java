package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateQueue;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class CreateQueueValidator extends AbstractModelValidator<CreateQueue> {

  public CreateQueueValidator(String fieldName) {
    super(fieldName);
  }

  public CreateQueueValidator() {}

  @Override
  protected Violation[] validateModel(CreateQueue createQueue) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .validate(createQueue.getName())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .validate(createQueue.getDisplayName())
      )
      .add(new StringValidator("description").maxLength(500).validate(createQueue.getDescription()))
      .aggregate();
  }
}
