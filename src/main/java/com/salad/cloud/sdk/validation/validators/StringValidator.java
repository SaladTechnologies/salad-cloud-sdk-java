package com.salad.cloud.sdk.validation.validators;

import com.salad.cloud.sdk.validation.Violation;
import java.util.ArrayList;
import java.util.List;

public class StringValidator extends AbstractValidator<String> {

  private Integer minLength;
  private Integer maxLength;
  private String pattern;

  public StringValidator(String fieldName) {
    super(fieldName);
  }

  public StringValidator() {}

  public StringValidator minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

  public StringValidator maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  public StringValidator pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  @Override
  public Violation[] validate(String value) {
    List<Violation> violations = new ArrayList<>();
    if (minLength != null && value.length() < minLength) {
      violations.add(new Violation(getFieldName(), String.format("must be at least %d characters long", minLength)));
    }
    if (maxLength != null && value.length() > maxLength) {
      violations.add(new Violation(getFieldName(), String.format("must be at most %d characters long", maxLength)));
    }
    if (pattern != null && !value.matches(pattern)) {
      violations.add(new Violation(getFieldName(), String.format("must match pattern %s", pattern)));
    }
    return violations.toArray(new Violation[0]);
  }
}
