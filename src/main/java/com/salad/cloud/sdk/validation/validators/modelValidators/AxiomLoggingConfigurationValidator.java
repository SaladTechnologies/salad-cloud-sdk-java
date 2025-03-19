package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.AxiomLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class AxiomLoggingConfigurationValidator extends AbstractModelValidator<AxiomLoggingConfiguration> {

  public AxiomLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public AxiomLoggingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(AxiomLoggingConfiguration axiomLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getHost())
      )
      .add(
        new StringValidator("apiToken")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getApiToken())
      )
      .add(
        new StringValidator("dataset")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(axiomLoggingConfiguration.getDataset())
      )
      .aggregate();
  }
}
