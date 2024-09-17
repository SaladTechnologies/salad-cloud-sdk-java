package com.salad.cloud.sdk.validation.validators;

import com.salad.cloud.sdk.validation.Violation;
import java.util.ArrayList;
import java.util.List;

public class ListValidator<T> extends AbstractValidator<List<T>> {

  private AbstractValidator<T> itemValidator;
  private Integer minLength;
  private Integer maxLength;
  private Boolean uniqueItems;

  public ListValidator(String fieldName) {
    super(fieldName);
  }

  public ListValidator() {}

  public ListValidator<T> minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

  public ListValidator<T> maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  public ListValidator<T> uniqueItems(Boolean uniqueItems) {
    this.uniqueItems = uniqueItems;
    return this;
  }

  public ListValidator<T> itemValidator(AbstractValidator<T> itemValidator) {
    this.itemValidator = itemValidator;
    return this;
  }

  @Override
  public Violation[] validate(List<T> list) {
    List<Violation> errors = new ArrayList<>();

    if (minLength != null && list.size() < minLength) {
      errors.add(new Violation(getFieldName(), String.format("must have at least %d items", minLength)));
    }

    if (maxLength != null && list.size() > maxLength) {
      errors.add(new Violation(getFieldName(), String.format("must have at most %d items", maxLength)));
    }

    if (uniqueItems != null && list.stream().distinct().count() != list.size()) {
      errors.add(new Violation(getFieldName(), "must have unique items"));
    }

    if (itemValidator != null) {
      for (int i = 0; i < list.size(); i++) {
        T item = list.get(i);
        Violation[] itemErrors = itemValidator.setFieldName(String.valueOf(i)).validate(item);
        for (Violation itemError : itemErrors) {
          errors.add(
            new Violation(String.format("%s[%s]", getFieldName(), itemValidator.getFieldName()), itemError.getMessage())
          );
        }
      }
    }

    return errors.toArray(new Violation[0]);
  }
}
