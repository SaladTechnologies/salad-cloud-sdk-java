package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.SystemLog;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class SystemLogValidator extends AbstractModelValidator<SystemLog> {

  public SystemLogValidator(String fieldName) {
    super(fieldName);
  }

  public SystemLogValidator() {}

  @Override
  protected Violation[] validateModel(SystemLog systemLog) {
    return new ViolationAggregator()
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
          .max(53687091200L)
          .optional()
          .validate(systemLog.getResourceStorageAmount())
      )
      .aggregate();
  }
}
