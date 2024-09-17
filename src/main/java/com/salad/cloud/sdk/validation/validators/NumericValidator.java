package com.salad.cloud.sdk.validation.validators;

import com.salad.cloud.sdk.validation.Violation;
import java.util.ArrayList;
import java.util.List;

public class NumericValidator<T extends Number> extends AbstractValidator<T> {

  private T minValue;
  private boolean minInclusive;
  private T maxValue;
  private boolean maxInclusive;

  public NumericValidator(String fieldName) {
    super(fieldName);
  }

  public NumericValidator() {}

  public NumericValidator<T> min(T min) {
    return min(min, true);
  }

  public NumericValidator<T> min(T min, boolean inclusive) {
    this.minValue = min;
    this.minInclusive = inclusive;
    return this;
  }

  public NumericValidator<T> max(T max) {
    return max(max, true);
  }

  public NumericValidator<T> max(T max, boolean inclusive) {
    this.maxValue = max;
    this.maxInclusive = inclusive;
    return this;
  }

  @Override
  public Violation[] validate(T value) {
    List<Violation> violations = new ArrayList<>();

    if (this.minValue != null) {
      if (this.minInclusive) {
        if (value.doubleValue() < this.minValue.doubleValue()) {
          violations.add(
            new Violation(getFieldName(), String.format("must be greater than or equal to %s", this.minValue))
          );
        }
      } else {
        if (value.doubleValue() <= this.minValue.doubleValue()) {
          violations.add(new Violation(getFieldName(), String.format("must be greater than %s", this.minValue)));
        }
      }
    }

    if (this.maxValue != null) {
      if (this.maxInclusive) {
        if (value.doubleValue() > this.maxValue.doubleValue()) {
          violations.add(
            new Violation(getFieldName(), String.format("must be less than or equal to %s", this.maxValue))
          );
        }
      } else {
        if (value.doubleValue() >= this.maxValue.doubleValue()) {
          violations.add(new Violation(getFieldName(), String.format("must be less than %s", this.maxValue)));
        }
      }
    }

    return violations.toArray(new Violation[0]);
  }
}
