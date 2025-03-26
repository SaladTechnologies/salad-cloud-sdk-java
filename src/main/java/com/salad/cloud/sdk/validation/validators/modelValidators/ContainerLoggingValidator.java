package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class ContainerLoggingValidator extends AbstractModelValidator<ContainerLogging> {

  public ContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(ContainerLogging containerLogging) {
    return new ViolationAggregator()
      .add(new AxiomLoggingConfigurationValidator("axiom").optional().validate(containerLogging.getAxiom()))
      .add(new DatadogLoggingConfigurationValidator("datadog").optional().validate(containerLogging.getDatadog()))
      .add(new ContainerLoggingConfigurationHttp1Validator("http").optional().validate(containerLogging.getHttp()))
      .add(new NewRelicLoggingConfigurationValidator("newRelic").optional().validate(containerLogging.getNewRelic()))
      .add(new ContainerLoggingSplunkConfigurationValidator("splunk").optional().validate(containerLogging.getSplunk()))
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(containerLogging.getTcp()))
      .aggregate();
  }
}
