package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupPatch;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupPatchValidator extends AbstractModelValidator<ContainerGroupPatch> {

  public ContainerGroupPatchValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupPatchValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroupPatch containerGroupPatch) {
    return new ViolationAggregator()
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(containerGroupPatch.getDisplayName())
      )
      .add(new UpdateContainerValidator("container").optional().validate(containerGroupPatch.getContainer()))
      .add(
        new NumericValidator<Long>("replicas").min(0L).max(500L).optional().validate(containerGroupPatch.getReplicas())
      )
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .optional()
          .validate(containerGroupPatch.getCountryCodes())
      )
      .add(
        new UpdateContainerGroupNetworkingValidator("networking")
          .optional()
          .validate(containerGroupPatch.getNetworking())
      )
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe")
          .optional()
          .validate(containerGroupPatch.getLivenessProbe())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(containerGroupPatch.getReadinessProbe())
      )
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe")
          .optional()
          .validate(containerGroupPatch.getStartupProbe())
      )
      .add(
        new QueueBasedAutoscalerConfigurationValidator("queueAutoscaler")
          .optional()
          .validate(containerGroupPatch.getQueueAutoscaler())
      )
      .aggregate();
  }
}
