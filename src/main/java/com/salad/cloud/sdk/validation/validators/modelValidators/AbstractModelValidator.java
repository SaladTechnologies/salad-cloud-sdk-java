package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.validators.AbstractValidator;
import java.util.Arrays;

public abstract class AbstractModelValidator<T> extends AbstractValidator<T> {

  public AbstractModelValidator(String fieldName) {
    super(fieldName);
  }

  public AbstractModelValidator() {}

  protected abstract Violation[] validateModel(T value);

  @Override
  public Violation[] validate(T value) {
    Violation[] violations = validateModel(value);
    if (violations.length == 0) {
      return violations;
    }
    return Arrays
      .stream(violations)
      .map(violation -> {
        String newPath = violation.getPath().isEmpty()
          ? getFieldName()
          : String.format("%s.%s", getFieldName(), violation.getPath());
        return new Violation(newPath, violation.getMessage());
      })
      .toArray(Violation[]::new);
  }
}
