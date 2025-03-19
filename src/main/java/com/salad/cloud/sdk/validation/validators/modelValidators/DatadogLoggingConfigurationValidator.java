package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.DatadogLoggingConfiguration;
import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class DatadogLoggingConfigurationValidator extends AbstractModelValidator<DatadogLoggingConfiguration> {

  public DatadogLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public DatadogLoggingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(DatadogLoggingConfiguration datadogLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogLoggingConfiguration.getHost())
      )
      .add(
        new StringValidator("apiKey")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(datadogLoggingConfiguration.getApiKey())
      )
      .add(
        new ListValidator<DatadogTagForContainerLogging>("tags")
          .maxLength(1000)
          .itemValidator(new DatadogTagForContainerLoggingValidator().required())
          .optional()
          .validate(datadogLoggingConfiguration.getTags())
      )
      .aggregate();
  }
}
