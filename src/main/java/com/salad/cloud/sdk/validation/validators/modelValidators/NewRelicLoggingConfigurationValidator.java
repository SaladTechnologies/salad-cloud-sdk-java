package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.NewRelicLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class NewRelicLoggingConfigurationValidator extends AbstractModelValidator<NewRelicLoggingConfiguration> {

  public NewRelicLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public NewRelicLoggingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(NewRelicLoggingConfiguration newRelicLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(newRelicLoggingConfiguration.getHost())
      )
      .add(
        new StringValidator("ingestionKey")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(newRelicLoggingConfiguration.getIngestionKey())
      )
      .aggregate();
  }
}
