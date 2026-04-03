package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupScalingAction;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroup model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupValidator extends AbstractModelValidator<ContainerGroup> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupValidator() {}

  /**
   * Validates the ContainerGroup model's fields and constraints.
   *
   * @param containerGroup The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroup containerGroup) {
    return new ViolationAggregator()
      .add(new ContainerValidator("container").required().validate(containerGroup.getContainer()))
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .maxLength(500)
          .required()
          .validate(containerGroup.getCountryCodes())
      )
      .add(new ContainerGroupStateValidator("currentState").required().validate(containerGroup.getCurrentState()))
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .required()
          .validate(containerGroup.getDisplayName())
      )
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroup.getName())
      )
      .add(
        new StringValidator("organizationName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroup.getOrganizationName())
      )
      .add(
        new StringValidator("projectName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroup.getProjectName())
      )
      .add(new NumericValidator<Long>("replicas").min(0L).max(500L).required().validate(containerGroup.getReplicas()))
      .add(
        new ListValidator<ContainerGroupScalingAction>("scalingActions")
          .maxLength(100)
          .itemValidator(new ContainerGroupScalingActionValidator().required())
          .required()
          .validate(containerGroup.getScalingActions())
      )
      .add(
        new NumericValidator<Long>("version").min(1L).max(2147483647L).required().validate(containerGroup.getVersion())
      )
      .add(
        new ContainerGroupLivenessProbeValidator("livenessProbe").optional().validate(containerGroup.getLivenessProbe())
      )
      .add(
        new ContainerGroupNetworkingConfigurationValidator("networking")
          .optional()
          .validate(containerGroup.getNetworking())
      )
      .add(
        new QueueBasedAutoscalerConfigurationValidator("queueAutoscaler")
          .optional()
          .validate(containerGroup.getQueueAutoscaler())
      )
      .add(
        new ContainerGroupQueueConnectionValidator("queueConnection")
          .optional()
          .validate(containerGroup.getQueueConnection())
      )
      .add(
        new ContainerGroupReadinessProbeValidator("readinessProbe")
          .optional()
          .validate(containerGroup.getReadinessProbe())
      )
      .add(new StringValidator("readme").minLength(2).maxLength(65000).optional().validate(containerGroup.getReadme()))
      .add(
        new ContainerGroupStartupProbeValidator("startupProbe").optional().validate(containerGroup.getStartupProbe())
      )
      .aggregate();
  }
}
