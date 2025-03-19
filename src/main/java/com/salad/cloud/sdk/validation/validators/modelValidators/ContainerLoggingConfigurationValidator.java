package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerLoggingConfigurationValidator extends AbstractModelValidator<ContainerLoggingConfiguration> {

  public ContainerLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerLoggingConfiguration containerLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new AxiomLoggingConfigurationValidator("axiom").optional().validate(containerLoggingConfiguration.getAxiom())
      )
      .add(
        new DatadogLoggingConfigurationValidator("datadog")
          .optional()
          .validate(containerLoggingConfiguration.getDatadog())
      )
      .add(
        new ContainerHttpLoggingConfigurationValidator("http")
          .optional()
          .validate(containerLoggingConfiguration.getHttp())
      )
      .add(
        new NewRelicLoggingConfigurationValidator("newRelic")
          .optional()
          .validate(containerLoggingConfiguration.getNewRelic())
      )
      .add(
        new ContainerLoggingSplunkConfigurationValidator("splunk")
          .optional()
          .validate(containerLoggingConfiguration.getSplunk())
      )
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(containerLoggingConfiguration.getTcp()))
      .aggregate();
  }
}
