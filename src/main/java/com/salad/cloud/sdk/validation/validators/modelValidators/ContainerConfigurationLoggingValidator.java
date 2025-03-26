package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerConfigurationLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerConfigurationLoggingValidator extends AbstractModelValidator<ContainerConfigurationLogging> {

  public ContainerConfigurationLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerConfigurationLoggingValidator() {}

  @Override
  protected Violation[] validateModel(ContainerConfigurationLogging containerConfigurationLogging) {
    return new ViolationAggregator()
      .add(
        new AxiomLoggingConfigurationValidator("axiom").optional().validate(containerConfigurationLogging.getAxiom())
      )
      .add(
        new DatadogLoggingConfigurationValidator("datadog")
          .optional()
          .validate(containerConfigurationLogging.getDatadog())
      )
      .add(
        new ContainerLoggingConfigurationHttp2Validator("http")
          .optional()
          .validate(containerConfigurationLogging.getHttp())
      )
      .add(
        new NewRelicLoggingConfigurationValidator("newRelic")
          .optional()
          .validate(containerConfigurationLogging.getNewRelic())
      )
      .add(
        new ContainerLoggingSplunkConfigurationValidator("splunk")
          .optional()
          .validate(containerConfigurationLogging.getSplunk())
      )
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(containerConfigurationLogging.getTcp()))
      .aggregate();
  }
}
