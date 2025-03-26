package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Container;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerValidator extends AbstractModelValidator<Container> {

  public ContainerValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerValidator() {}

  @Override
  protected Violation[] validateModel(Container container) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("command")
          .maxLength(100)
          .itemValidator(new StringValidator().minLength(1).maxLength(2048).pattern("^.*$").required())
          .optional()
          .validate(container.getCommand())
      )
      .add(
        new StringValidator("image")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .required()
          .validate(container.getImage())
      )
      .add(new ContainerResourceRequirementsValidator("resources").required().validate(container.getResources()))
      .add(
        new StringValidator("hash")
          .minLength(47)
          .maxLength(135)
          .pattern("^sha\\d{1,3}:[a-fA-F0-9]{40,135}$")
          .optional()
          .validate(container.getHash())
      )
      .add(new ContainerLoggingValidator("logging").optional().validate(container.getLogging()))
      .add(
        new NumericValidator<Long>("size").min(0L).max(9223372036854775807L).optional().validate(container.getSize())
      )
      .aggregate();
  }
}
