package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateContainer;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class CreateContainerValidator extends AbstractModelValidator<CreateContainer> {

  public CreateContainerValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainer createContainer) {
    return new ViolationAggregator()
      .add(new StringValidator("image").minLength(1).maxLength(1024), createContainer.getImage())
      .add(new ListValidator<String>("command").maxLength(100), createContainer.getCommand())
      .add(new CreateContainerLoggingValidator("logging"), createContainer.getLogging())
      .aggregate();
  }
}
