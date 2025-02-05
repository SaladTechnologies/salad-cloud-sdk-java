package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

public class ContainerGroupReadinessProbeValidator extends AbstractModelValidator<ContainerGroupReadinessProbe> {

  public ContainerGroupReadinessProbeValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupReadinessProbeValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupReadinessProbe containerGroupReadinessProbe) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("initialDelaySeconds")
          .min(0L)
          .required()
          .validate(containerGroupReadinessProbe.getInitialDelaySeconds())
      )
      .add(
        new NumericValidator<Long>("periodSeconds")
          .min(1L)
          .required()
          .validate(containerGroupReadinessProbe.getPeriodSeconds())
      )
      .add(
        new NumericValidator<Long>("timeoutSeconds")
          .min(1L)
          .required()
          .validate(containerGroupReadinessProbe.getTimeoutSeconds())
      )
      .add(
        new NumericValidator<Long>("successThreshold")
          .min(1L)
          .required()
          .validate(containerGroupReadinessProbe.getSuccessThreshold())
      )
      .add(
        new NumericValidator<Long>("failureThreshold")
          .min(1L)
          .required()
          .validate(containerGroupReadinessProbe.getFailureThreshold())
      )
      .add(new ContainerGroupProbeTcpValidator("tcp").optional().validate(containerGroupReadinessProbe.getTcp()))
      .add(new ContainerGroupProbeHttpValidator("http").optional().validate(containerGroupReadinessProbe.getHttp()))
      .add(new ContainerGroupProbeGrpcValidator("grpc").optional().validate(containerGroupReadinessProbe.getGrpc()))
      .aggregate();
  }
}
