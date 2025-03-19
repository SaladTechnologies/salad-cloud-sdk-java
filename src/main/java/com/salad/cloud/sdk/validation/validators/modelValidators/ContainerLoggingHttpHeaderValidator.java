package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerLoggingHttpHeaderValidator extends AbstractModelValidator<ContainerLoggingHttpHeader> {

  public ContainerLoggingHttpHeaderValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingHttpHeaderValidator() {}

  @Override
  protected Violation[] validateModel(ContainerLoggingHttpHeader containerLoggingHttpHeader) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingHttpHeader.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingHttpHeader.getValue())
      )
      .aggregate();
  }
}
