package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupQueueConnection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupQueueConnection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupQueueConnectionValidator extends AbstractModelValidator<ContainerGroupQueueConnection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupQueueConnectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupQueueConnectionValidator() {}

  /**
   * Validates the ContainerGroupQueueConnection model's fields and constraints.
   *
   * @param containerGroupQueueConnection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupQueueConnection containerGroupQueueConnection) {
    return new ViolationAggregator()
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(1024)
          .pattern("^.*$")
          .required()
          .validate(containerGroupQueueConnection.getPath())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerGroupQueueConnection.getPort())
      )
      .add(
        new StringValidator("queueName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .required()
          .validate(containerGroupQueueConnection.getQueueName())
      )
      .aggregate();
  }
}
