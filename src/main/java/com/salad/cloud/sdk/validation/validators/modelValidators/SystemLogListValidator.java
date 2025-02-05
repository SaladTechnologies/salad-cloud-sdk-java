package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.SystemLog;
import com.salad.cloud.sdk.models.SystemLogList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class SystemLogListValidator extends AbstractModelValidator<SystemLogList> {

  public SystemLogListValidator(String fieldName) {
    super(fieldName);
  }

  public SystemLogListValidator() {}

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
