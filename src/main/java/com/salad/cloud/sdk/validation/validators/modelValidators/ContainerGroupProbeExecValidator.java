package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupProbeExecValidator extends AbstractModelValidator<ContainerGroupProbeExec> {

  public ContainerGroupProbeExecValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupProbeExecValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupProbeExec containerGroupProbeExec) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("command")
          .minLength(1)
          .maxLength(100)
          .itemValidator(new StringValidator().minLength(1).maxLength(2048).pattern("^.*$").required())
          .required()
          .validate(containerGroupProbeExec.getCommand())
      )
      .aggregate();
  }
}
