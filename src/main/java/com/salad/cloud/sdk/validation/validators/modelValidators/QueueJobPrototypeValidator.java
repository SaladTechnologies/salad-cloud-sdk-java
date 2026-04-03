package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJobPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for QueueJobPrototype model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueueJobPrototypeValidator extends AbstractModelValidator<QueueJobPrototype> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueueJobPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueueJobPrototypeValidator() {}

  /**
   * Validates the QueueJobPrototype model's fields and constraints.
   *
   * @param queueJobPrototype The model instance to validate
   * @return Array of violations found during validation
   */
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
