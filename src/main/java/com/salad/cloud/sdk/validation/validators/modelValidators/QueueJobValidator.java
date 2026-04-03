package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobEvent;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for QueueJob model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueueJobValidator extends AbstractModelValidator<QueueJob> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueueJobValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueueJobValidator() {}

  /**
   * Validates the QueueJob model's fields and constraints.
   *
   * @param queueJob The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(QueueJob queueJob) {
    return new ViolationAggregator()
      .add(new ListValidator<QueueJobEvent>("events").maxLength(1000).required().validate(queueJob.getEvents()))
      .add(
        new StringValidator("webhook")
          .minLength(20)
          .maxLength(27)
          .pattern("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[+-]\\d{2}:\\d{2})$")
          .optional()
          .validate(queueJob.getWebhook())
      )
      .aggregate();
  }
}
