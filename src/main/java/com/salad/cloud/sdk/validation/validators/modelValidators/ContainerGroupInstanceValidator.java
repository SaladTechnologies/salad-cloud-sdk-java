package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupInstance model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupInstanceValidator extends AbstractModelValidator<ContainerGroupInstance> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupInstanceValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupInstanceValidator() {}

  /**
   * Validates the ContainerGroupInstance model's fields and constraints.
   *
   * @param containerGroupInstance The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupInstance containerGroupInstance) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("version")
          .min(1L)
          .max(2147483647L)
          .required()
          .validate(containerGroupInstance.getVersion())
      )
      .add(
        new NumericValidator<Double>("cpuPercent").min(0D).optional().validate(containerGroupInstance.getCpuPercent())
      )
      .add(new NumericValidator<Long>("cpuUsage").min(0L).optional().validate(containerGroupInstance.getCpuUsage()))
      .add(
        new NumericValidator<Long>("cpuUsageTotal")
          .min(0L)
          .optional()
          .validate(containerGroupInstance.getCpuUsageTotal())
      )
      .add(
        new NumericValidator<Long>("deletionCost")
          .min(0L)
          .max(100000L)
          .optional()
          .validate(containerGroupInstance.getDeletionCost())
      )
      .add(
        new NumericValidator<Double>("memoryUsageMb")
          .min(0D)
          .optional()
          .validate(containerGroupInstance.getMemoryUsageMb())
      )
      .add(
        new NumericValidator<Double>("memoryUsagePercent")
          .min(0D)
          .optional()
          .validate(containerGroupInstance.getMemoryUsagePercent())
      )
      .add(
        new NumericValidator<Double>("pullingProgress")
          .min(0D)
          .max(100D)
          .optional()
          .validate(containerGroupInstance.getPullingProgress())
      )
      .add(
        new StringValidator("sshHostKeyFingerprint")
          .minLength(1)
          .maxLength(256)
          .optional()
          .validate(containerGroupInstance.getSshHostKeyFingerprint())
      )
      .add(
        new NumericValidator<Long>("sshPort")
          .min(1L)
          .max(65535L)
          .optional()
          .validate(containerGroupInstance.getSshPort())
      )
      .aggregate();
  }
}
