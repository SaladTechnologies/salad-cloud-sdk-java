package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupsQuotas;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ContainerGroupsQuotas model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupsQuotasValidator extends AbstractModelValidator<ContainerGroupsQuotas> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupsQuotasValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupsQuotasValidator() {}

  /**
   * Validates the ContainerGroupsQuotas model's fields and constraints.
   *
   * @param containerGroupsQuotas The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupsQuotas containerGroupsQuotas) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("containerReplicasQuota")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupsQuotas.getContainerReplicasQuota())
      )
      .add(
        new NumericValidator<Long>("containerReplicasUsed")
          .min(0L)
          .max(2147483647L)
          .required()
          .validate(containerGroupsQuotas.getContainerReplicasUsed())
      )
      .add(
        new NumericValidator<Long>("maxContainerGroupReallocationsPerMinute")
          .min(0L)
          .max(2147483647L)
          .optional()
          .validate(containerGroupsQuotas.getMaxContainerGroupReallocationsPerMinute())
      )
      .add(
        new NumericValidator<Long>("maxContainerGroupRecreatesPerMinute")
          .min(0L)
          .max(2147483647L)
          .optional()
          .validate(containerGroupsQuotas.getMaxContainerGroupRecreatesPerMinute())
      )
      .add(
        new NumericValidator<Long>("maxContainerGroupRestartsPerMinute")
          .min(0L)
          .max(2147483647L)
          .optional()
          .validate(containerGroupsQuotas.getMaxContainerGroupRestartsPerMinute())
      )
      .aggregate();
  }
}
