package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class ContainerGroupCollectionValidator extends AbstractModelValidator<ContainerGroupCollection> {

  public ContainerGroupCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupCollectionValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupCollection containerGroupCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroup>("items")
          .maxLength(100)
          .itemValidator(new ContainerGroupValidator().required())
          .required()
          .validate(containerGroupCollection.getItems())
      )
      .aggregate();
  }
}
