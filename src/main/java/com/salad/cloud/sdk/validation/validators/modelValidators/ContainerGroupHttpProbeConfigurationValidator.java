package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupHttpProbeConfiguration;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupHttpProbeConfigurationValidator
  extends AbstractModelValidator<ContainerGroupHttpProbeConfiguration> {

  public ContainerGroupHttpProbeConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupHttpProbeConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupHttpProbeConfiguration containerGroupHttpProbeConfiguration) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroupProbeHttpHeader>("headers")
          .minLength(1)
          .maxLength(50)
          .itemValidator(new ContainerGroupProbeHttpHeaderValidator().required())
          .required()
          .validate(containerGroupHttpProbeConfiguration.getHeaders())
      )
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .required()
          .validate(containerGroupHttpProbeConfiguration.getPath())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(0L)
          .max(65536L)
          .required()
          .validate(containerGroupHttpProbeConfiguration.getPort())
      )
      .aggregate();
  }
}
