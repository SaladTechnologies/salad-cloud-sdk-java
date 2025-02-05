package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupStartupProbeValidator extends AbstractModelValidator<ContainerGroupStartupProbe> {

  public ContainerGroupStartupProbeValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupStartupProbeValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupStartupProbe containerGroupStartupProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .required()
          .validate(containerGroupStartupProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .required()
          .validate(containerGroupStartupProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .required()
          .validate(containerGroupStartupProbe.getTimeoutSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .required()
          .validate(containerGroupStartupProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .required()
          .validate(containerGroupStartupProbe.getFailureThreshold())
      )
      .add(new ContainerGroupProbeTcpValidator("tcp").optional().validate(containerGroupStartupProbe.getTcp()))
      .add(new ContainerGroupProbeHttpValidator("http").optional().validate(containerGroupStartupProbe.getHttp()))
      .add(new ContainerGroupProbeGrpcValidator("grpc").optional().validate(containerGroupStartupProbe.getGrpc()))
      .aggregate();
  }
}
