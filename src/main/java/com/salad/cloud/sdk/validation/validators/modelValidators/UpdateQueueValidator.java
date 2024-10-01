package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateQueue;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class UpdateQueueValidator extends AbstractModelValidator<UpdateQueue> {

  public UpdateQueueValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateQueueValidator() {}

  @Override
  protected Violation[] validateModel(UpdateQueue updateQueue) {
    return new ViolationAggregator()
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .validate(updateQueue.getDisplayName())
      )
      .add(new StringValidator("description").maxLength(500).validate(updateQueue.getDescription()))
      .aggregate();
  }
}
