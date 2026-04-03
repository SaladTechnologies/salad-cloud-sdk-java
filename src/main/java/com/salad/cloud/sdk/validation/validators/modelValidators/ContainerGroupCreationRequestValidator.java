package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupCreationRequest;
import com.salad.cloud.sdk.models.ContainerGroupScalingAction;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupCreationRequest model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupCreationRequestValidator extends AbstractModelValidator<ContainerGroupCreationRequest> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupCreationRequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupCreationRequestValidator() {}

  /**
   * Validates the ContainerGroupCreationRequest model's fields and constraints.
   *
   * @param containerGroupCreationRequest The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupCreationRequest containerGroupCreationRequest) {
    return new ViolationAggregator()
      .add(
        new ContainerConfigurationValidator("container")
          .required()
          .validate(containerGroupCreationRequest.getContainer())
      )
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroupCreationRequest.getName())
      )
      .add(
        new NumericValidator<Long>("replicas")
          .min(0L)
          .max(500L)
          .required()
          .validate(containerGroupCreationRequest.getReplicas())
      )
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .optional()
          .validate(containerGroupCreationRequest.getCountryCodes())
      )
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .optional()
          .validate(containerGroupCreationRequest.getDisplayName())
      )
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe")
          .optional()
          .validate(containerGroupCreationRequest.getLivenessProbe())
      )
      .add(
        new CreateContainerGroupNetworkingValidator("networking")
          .optional()
          .validate(containerGroupCreationRequest.getNetworking())
      )
      .add(
        new QueueBasedAutoscalerConfigurationValidator("queueAutoscaler")
          .optional()
          .validate(containerGroupCreationRequest.getQueueAutoscaler())
      )
      .add(
        new ContainerGroupQueueConnectionValidator("queueConnection")
          .optional()
          .validate(containerGroupCreationRequest.getQueueConnection())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(containerGroupCreationRequest.getReadinessProbe())
      )
      .add(
        new ListValidator<ContainerGroupScalingAction>("scalingActions")
          .maxLength(100)
          .itemValidator(new ContainerGroupScalingActionValidator().required())
          .optional()
          .validate(containerGroupCreationRequest.getScalingActions())
      )
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe")
          .optional()
          .validate(containerGroupCreationRequest.getStartupProbe())
      )
      .aggregate();
  }
}
