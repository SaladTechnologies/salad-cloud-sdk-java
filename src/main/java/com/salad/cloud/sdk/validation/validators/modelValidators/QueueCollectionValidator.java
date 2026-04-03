package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueueCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for QueueCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueueCollectionValidator extends AbstractModelValidator<QueueCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueueCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueueCollectionValidator() {}

  /**
   * Validates the QueueCollection model's fields and constraints.
   *
   * @param queueCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(QueueCollection queueCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<Queue>("items")
          .maxLength(100)
          .itemValidator(new QueueValidator().required())
          .required()
          .validate(queueCollection.getItems())
      )
      .aggregate();
  }
}
