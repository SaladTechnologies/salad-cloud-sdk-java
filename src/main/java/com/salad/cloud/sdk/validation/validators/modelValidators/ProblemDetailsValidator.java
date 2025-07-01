package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ProblemDetails;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ProblemDetailsValidator extends AbstractModelValidator<ProblemDetails> {

  public ProblemDetailsValidator(String fieldName) {
    super(fieldName);
  }

  public ProblemDetailsValidator() {}

  @Override
  protected Violation[] validateModel(ProblemDetails problemDetails) {
    return new ViolationAggregator()
      .add(new StringValidator("type").minLength(1).maxLength(2048).optional().validate(problemDetails.getType()))
      .add(new StringValidator("title").minLength(1).maxLength(2000).optional().validate(problemDetails.getTitle()))
      .add(new NumericValidator<Long>("status").min(100L).max(599L).optional().validate(problemDetails.getStatus()))
      .add(new StringValidator("detail").minLength(1).maxLength(2000).optional().validate(problemDetails.getDetail()))
      .add(
        new StringValidator("instance").minLength(1).maxLength(2048).optional().validate(problemDetails.getInstance())
      )
      .aggregate();
  }
}
