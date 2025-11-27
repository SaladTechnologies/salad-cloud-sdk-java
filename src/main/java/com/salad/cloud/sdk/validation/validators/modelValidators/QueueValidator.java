package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class QueueValidator extends AbstractModelValidator<Queue> {

  public QueueValidator(String fieldName) {
    super(fieldName);
  }

  public QueueValidator() {}

  @Override
  protected Violation[] validateModel(Queue queue) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(queue.getName())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .required()
          .validate(queue.getDisplayName())
      )
      .add(
        new ListValidator<ContainerGroup>("containerGroups")
          .maxLength(100)
          .itemValidator(new ContainerGroupValidator().required())
          .required()
          .validate(queue.getContainerGroups())
      )
      .add(
        new StringValidator("description").maxLength(500).pattern("^.*$").optional().validate(queue.getDescription())
      )
      .add(
        new NumericValidator<Long>("currentQueueLength")
          .min(0L)
          .max(2147483647L)
          .optional()
          .validate(queue.getCurrentQueueLength())
      )
      .aggregate();
  }
}
