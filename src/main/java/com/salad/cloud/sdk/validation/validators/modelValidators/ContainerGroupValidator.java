package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupValidator extends AbstractModelValidator<ContainerGroup> {

  public ContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroup containerGroup) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroup.getName())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .required()
          .validate(containerGroup.getDisplayName())
      )
      .add(new ContainerValidator("container").required().validate(containerGroup.getContainer()))
      .add(new NumericValidator<Long>("replicas").min(0L).max(100L).required().validate(containerGroup.getReplicas()))
      .add(new ContainerGroupStateValidator("currentState").required().validate(containerGroup.getCurrentState()))
      .add(new NumericValidator<Long>("version").min(1L).required().validate(containerGroup.getVersion()))
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .optional()
          .validate(containerGroup.getCountryCodes())
      )
      .add(new ContainerGroupNetworkingValidator("networking").optional().validate(containerGroup.getNetworking()))
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe").optional().validate(containerGroup.getLivenessProbe())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(containerGroup.getReadinessProbe())
      )
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe").optional().validate(containerGroup.getStartupProbe())
      )
      .add(
        new ContainerGroupQueueConnectionValidator("queueConnection")
          .optional()
          .validate(containerGroup.getQueueConnection())
      )
      .add(new QueueAutoscalerValidator("queueAutoscaler").optional().validate(containerGroup.getQueueAutoscaler()))
      .aggregate();
  }
}
