package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class ContainerGroupListValidator extends AbstractModelValidator<ContainerGroupList> {

  public ContainerGroupListValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupListValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupList containerGroupList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroup>("items").maxLength(100).itemValidator(new ContainerGroupValidator()),
        containerGroupList.getItems()
      )
      .aggregate();
  }
}
