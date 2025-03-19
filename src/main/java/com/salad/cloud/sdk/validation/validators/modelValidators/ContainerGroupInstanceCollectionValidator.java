package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstanceCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

public class ContainerGroupInstanceCollectionValidator
  extends AbstractModelValidator<ContainerGroupInstanceCollection> {

  public ContainerGroupInstanceCollectionValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupInstanceCollectionValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupInstanceCollection containerGroupInstanceCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroupInstance>("instances")
          .maxLength(1000)
          .itemValidator(new ContainerGroupInstanceValidator().required())
          .required()
          .validate(containerGroupInstanceCollection.getInstances())
      )
      .aggregate();
  }
}
