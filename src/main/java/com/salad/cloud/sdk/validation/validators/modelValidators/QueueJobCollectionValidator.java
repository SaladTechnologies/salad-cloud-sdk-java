package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.QueueJob;
import com.salad.cloud.sdk.models.QueueJobCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for QueueJobCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QueueJobCollectionValidator extends AbstractModelValidator<QueueJobCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QueueJobCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QueueJobCollectionValidator() {}

  /**
   * Validates the QueueJobCollection model's fields and constraints.
   *
   * @param queueJobCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(QueueJobCollection queueJobCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<QueueJob>("items")
          .maxLength(100)
          .itemValidator(new QueueJobValidator().required())
          .required()
          .validate(queueJobCollection.getItems())
      )
      .aggregate();
  }
}
