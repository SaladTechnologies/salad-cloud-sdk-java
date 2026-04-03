package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueuePrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for QueuePrototype model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueuePrototypeValidator extends AbstractModelValidator<QueuePrototype> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueuePrototypeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueuePrototypeValidator() {}

  /**
   * Validates the QueuePrototype model's fields and constraints.
   *
   * @param queuePrototype The model instance to validate
   * @return Array of violations found during validation
   */
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
        new StringValidator("description")
          .maxLength(500)
          .pattern("^.*$")
          .optional()
          .validate(queuePrototype.getDescription())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(queuePrototype.getDisplayName())
      )
      .aggregate();
  }
}
