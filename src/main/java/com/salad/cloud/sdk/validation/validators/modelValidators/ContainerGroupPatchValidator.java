package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupPatch;
import com.salad.cloud.sdk.models.ContainerGroupScalingAction;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupPatch model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupPatchValidator extends AbstractModelValidator<ContainerGroupPatch> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupPatchValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupPatchValidator() {}

  /**
   * Validates the ContainerGroupPatch model's fields and constraints.
   *
   * @param containerGroupPatch The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupPatch containerGroupPatch) {
    return new ViolationAggregator()
      .add(new UpdateContainerValidator("container").optional().validate(containerGroupPatch.getContainer()))
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .optional()
          .validate(containerGroupPatch.getCountryCodes())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(containerGroupPatch.getDisplayName())
      )
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe")
          .optional()
          .validate(containerGroupPatch.getLivenessProbe())
      )
      .add(
        new UpdateContainerGroupNetworkingValidator("networking")
          .optional()
          .validate(containerGroupPatch.getNetworking())
      )
      .add(
        new QueueBasedAutoscalerConfigurationValidator("queueAutoscaler")
          .optional()
          .validate(containerGroupPatch.getQueueAutoscaler())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(containerGroupPatch.getReadinessProbe())
      )
      .add(
        new NumericValidator<Long>("replicas").min(0L).max(500L).optional().validate(containerGroupPatch.getReplicas())
      )
      .add(
        new ListValidator<ContainerGroupScalingAction>("scalingActions")
          .maxLength(100)
          .itemValidator(new ContainerGroupScalingActionValidator().required())
          .optional()
          .validate(containerGroupPatch.getScalingActions())
      )
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe")
          .optional()
          .validate(containerGroupPatch.getStartupProbe())
      )
      .aggregate();
  }
}
