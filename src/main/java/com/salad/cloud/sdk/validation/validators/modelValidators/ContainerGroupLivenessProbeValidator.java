package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupLivenessProbeValidator extends AbstractModelValidator<ContainerGroupLivenessProbe> {

  public ContainerGroupLivenessProbeValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupLivenessProbeValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupLivenessProbe containerGroupLivenessProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .required()
          .validate(containerGroupLivenessProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .required()
          .validate(containerGroupLivenessProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .required()
          .validate(containerGroupLivenessProbe.getTimeoutSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .required()
          .validate(containerGroupLivenessProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .required()
          .validate(containerGroupLivenessProbe.getFailureThreshold())
      )
      .add(new ContainerGroupProbeTcpValidator("tcp").optional().validate(containerGroupLivenessProbe.getTcp()))
      .add(new ContainerGroupProbeHttpValidator("http").optional().validate(containerGroupLivenessProbe.getHttp()))
      .add(new ContainerGroupProbeGrpcValidator("grpc").optional().validate(containerGroupLivenessProbe.getGrpc()))
      .aggregate();
  }
}
