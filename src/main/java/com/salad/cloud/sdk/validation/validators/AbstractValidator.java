package com.salad.cloud.sdk.validation.validators;

public abstract class AbstractValidator<T> implements Validator<T> {

  private String fieldName;

  public AbstractValidator(String fieldName) {
    this.fieldName = fieldName;
  }

  public AbstractValidator() {
    this.fieldName = "";
  }

  public String getFieldName() {
    return fieldName;
  }

  public AbstractValidator<T> setFieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }
}
