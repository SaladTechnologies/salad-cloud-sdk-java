package com.salad.cloud.sdk.validation.validators;

import com.salad.cloud.sdk.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
