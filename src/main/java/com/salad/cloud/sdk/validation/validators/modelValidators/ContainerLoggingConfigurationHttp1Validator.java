package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp1;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerLoggingConfigurationHttp1 model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerLoggingConfigurationHttp1Validator
  extends AbstractModelValidator<ContainerLoggingConfigurationHttp1> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerLoggingConfigurationHttp1Validator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerLoggingConfigurationHttp1Validator() {}

  /**
   * Validates the ContainerLoggingConfigurationHttp1 model's fields and constraints.
   *
   * @param containerLoggingConfigurationHttp1 The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerLoggingConfigurationHttp1 containerLoggingConfigurationHttp1) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerLoggingHttpHeader>("headers")
          .maxLength(1000)
          .itemValidator(new ContainerLoggingHttpHeaderValidator().required())
          .optional()
          .validate(containerLoggingConfigurationHttp1.getHeaders())
      )
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingConfigurationHttp1.getHost())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerLoggingConfigurationHttp1.getPort())
      )
      .add(
        new StringValidator("password")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp1.getPassword())
      )
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp1.getPath())
      )
      .add(
        new StringValidator("user")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp1.getUser())
      )
      .aggregate();
  }
}
