package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ProblemDetails;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ProblemDetails model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ProblemDetailsValidator extends AbstractModelValidator<ProblemDetails> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ProblemDetailsValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ProblemDetailsValidator() {}

  /**
   * Validates the ProblemDetails model's fields and constraints.
   *
   * @param problemDetails The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ProblemDetails problemDetails) {
    return new ViolationAggregator()
      .add(new StringValidator("detail").minLength(1).maxLength(2000).optional().validate(problemDetails.getDetail()))
      .add(
        new StringValidator("instance").minLength(1).maxLength(2048).optional().validate(problemDetails.getInstance())
      )
      .add(new NumericValidator<Long>("status").min(100L).max(599L).optional().validate(problemDetails.getStatus()))
      .add(new StringValidator("title").minLength(1).maxLength(2000).optional().validate(problemDetails.getTitle()))
      .add(new StringValidator("type").minLength(1).maxLength(2048).optional().validate(problemDetails.getType()))
      .aggregate();
  }
}
