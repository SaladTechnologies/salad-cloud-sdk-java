package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.CreateContainerGroup;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class CreateContainerGroupValidator extends AbstractModelValidator<CreateContainerGroup> {

  public CreateContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerGroupValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainerGroup createContainerGroup) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(createContainerGroup.getName())
      )
      .add(new CreateContainerValidator("container").required().validate(createContainerGroup.getContainer()))
      .add(
        new NumericValidator<Long>("replicas").min(0L).max(500L).required().validate(createContainerGroup.getReplicas())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(createContainerGroup.getDisplayName())
      )
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .optional()
          .validate(createContainerGroup.getCountryCodes())
      )
      .add(
        new CreateContainerGroupNetworkingValidator("networking")
          .optional()
          .validate(createContainerGroup.getNetworking())
      )
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe")
          .optional()
          .validate(createContainerGroup.getLivenessProbe())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(createContainerGroup.getReadinessProbe())
      )
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe")
          .optional()
          .validate(createContainerGroup.getStartupProbe())
      )
      .add(
        new ContainerGroupQueueConnectionValidator("queueConnection")
          .optional()
          .validate(createContainerGroup.getQueueConnection())
      )
      .add(
        new QueueAutoscalerValidator("queueAutoscaler").optional().validate(createContainerGroup.getQueueAutoscaler())
      )
      .aggregate();
  }
}
