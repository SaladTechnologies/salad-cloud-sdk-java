package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueuePatch;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for QueuePatch model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueuePatchValidator extends AbstractModelValidator<QueuePatch> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueuePatchValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueuePatchValidator() {}

  /**
   * Validates the QueuePatch model's fields and constraints.
   *
   * @param queuePatch The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(QueuePatch queuePatch) {
    return new ViolationAggregator()
      .add(
        new StringValidator("description")
          .maxLength(500)
          .pattern("^.*$")
          .optional()
          .validate(queuePatch.getDescription())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(queuePatch.getDisplayName())
      )
      .aggregate();
  }
}
