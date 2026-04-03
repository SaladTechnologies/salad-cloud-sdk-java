package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.SystemLog;
import com.salad.cloud.sdk.models.SystemLogList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for SystemLogList model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SystemLogListValidator extends AbstractModelValidator<SystemLogList> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SystemLogListValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SystemLogListValidator() {}

  /**
   * Validates the SystemLogList model's fields and constraints.
   *
   * @param systemLogList The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SystemLogList systemLogList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<SystemLog>("items")
          .maxLength(50)
          .itemValidator(new SystemLogValidator().required())
          .required()
          .validate(systemLogList.getItems())
      )
      .aggregate();
  }
}
