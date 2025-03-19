package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueuePatch;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class QueuePatchValidator extends AbstractModelValidator<QueuePatch> {

  public QueuePatchValidator(String fieldName) {
    super(fieldName);
  }

  public QueuePatchValidator() {}

  @Override
  protected Violation[] validateModel(QueuePatch queuePatch) {
    return new ViolationAggregator()
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(queuePatch.getDisplayName())
      )
      .add(
        new StringValidator("description")
          .maxLength(500)
          .pattern("^.*$")
          .optional()
          .validate(queuePatch.getDescription())
      )
      .aggregate();
  }
}
