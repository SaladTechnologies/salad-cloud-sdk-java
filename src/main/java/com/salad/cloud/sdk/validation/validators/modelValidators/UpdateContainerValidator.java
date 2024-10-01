package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainer;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class UpdateContainerValidator extends AbstractModelValidator<UpdateContainer> {

  public UpdateContainerValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateContainerValidator() {}

  @Override
  protected Violation[] validateModel(UpdateContainer updateContainer) {
    return new ViolationAggregator()
      .add(new StringValidator("image").minLength(1).maxLength(1024).validate(updateContainer.getImage()))
      .add(new ListValidator<String>("command").maxLength(100).validate(updateContainer.getCommand()))
      .add(new UpdateContainerLoggingValidator("logging").validate(updateContainer.getLogging()))
      .aggregate();
  }
}
