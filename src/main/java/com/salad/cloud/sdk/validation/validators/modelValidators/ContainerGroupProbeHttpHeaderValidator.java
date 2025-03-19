package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupProbeHttpHeaderValidator extends AbstractModelValidator<ContainerGroupProbeHttpHeader> {

  public ContainerGroupProbeHttpHeaderValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupProbeHttpHeaderValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupProbeHttpHeader containerGroupProbeHttpHeader) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(1)
          .maxLength(256)
          .pattern("^.*$")
          .required()
          .validate(containerGroupProbeHttpHeader.getName())
      )
      .add(
        new StringValidator("value")
          .minLength(1)
          .maxLength(1024)
          .pattern("^.*$")
          .required()
          .validate(containerGroupProbeHttpHeader.getValue())
      )
      .aggregate();
  }
}
