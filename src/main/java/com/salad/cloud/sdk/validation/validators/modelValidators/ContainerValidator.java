package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Container;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerValidator extends AbstractModelValidator<Container> {

  public ContainerValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerValidator() {}

  @Override
  protected Violation[] validateModel(Container container) {
    return new ViolationAggregator()
      .add(new StringValidator("image").minLength(1).maxLength(1024), container.getImage())
      .add(new ListValidator<String>("command").maxLength(100), container.getCommand())
      .add(new ContainerLoggingValidator("logging"), container.getLogging())
      .aggregate();
  }
}
