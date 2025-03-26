package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainerLogging;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class UpdateContainerLoggingValidator extends AbstractModelValidator<UpdateContainerLogging> {

  public UpdateContainerLoggingValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateContainerLoggingValidator() {}

  @Override
  protected Violation[] validateModel(UpdateContainerLogging updateContainerLogging) {
    return new ViolationAggregator()
      .add(new AxiomLoggingConfigurationValidator("axiom").optional().validate(updateContainerLogging.getAxiom()))
      .add(new DatadogLoggingConfigurationValidator("datadog").optional().validate(updateContainerLogging.getDatadog()))
      .add(
        new ContainerLoggingConfigurationHttp1Validator("http").optional().validate(updateContainerLogging.getHttp())
      )
      .add(
        new NewRelicLoggingConfigurationValidator("newRelic").optional().validate(updateContainerLogging.getNewRelic())
      )
      .add(
        new ContainerLoggingSplunkConfigurationValidator("splunk")
          .optional()
          .validate(updateContainerLogging.getSplunk())
      )
      .add(new TcpLoggingConfigurationValidator("tcp").optional().validate(updateContainerLogging.getTcp()))
      .aggregate();
  }
}
