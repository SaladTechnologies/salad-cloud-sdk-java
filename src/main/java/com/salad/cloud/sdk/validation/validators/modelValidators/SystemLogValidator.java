package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.SystemLog;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for SystemLog model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SystemLogValidator extends AbstractModelValidator<SystemLog> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SystemLogValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SystemLogValidator() {}

  /**
   * Validates the SystemLog model's fields and constraints.
   *
   * @param systemLog The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SystemLog systemLog) {
    return new ViolationAggregator()
      .add(
        new StringValidator("eventName")
          .minLength(1)
          .maxLength(255)
          .pattern("^.*$")
          .required()
          .validate(systemLog.getEventName())
      )
      .add(new NumericValidator<Long>("resourceCpu").min(1L).max(16L).optional().validate(systemLog.getResourceCpu()))
      .add(
        new NumericValidator<Long>("resourceMemory")
          .min(1024L)
          .max(61440L)
          .optional()
          .validate(systemLog.getResourceMemory())
      )
      .add(
        new NumericValidator<Long>("resourceStorageAmount")
          .min(1073741824L)
          .max(268435456000L)
          .optional()
          .validate(systemLog.getResourceStorageAmount())
      )
      .aggregate();
  }
}
