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
      .add(new StringValidator("image").minLength(1).maxLength(1024).required().validate(createContainer.getImage()))
      .add(new ContainerResourceRequirementsValidator("resources").required().validate(createContainer.getResources()))
      .add(new ListValidator<String>("command").maxLength(100).optional().validate(createContainer.getCommand()))
      .add(new CreateContainerLoggingValidator("logging").optional().validate(createContainer.getLogging()))
      .aggregate();
  }
}
