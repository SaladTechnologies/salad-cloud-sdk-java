package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.TcpLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for TcpLoggingConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TcpLoggingConfigurationValidator extends AbstractModelValidator<TcpLoggingConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TcpLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TcpLoggingConfigurationValidator() {}

  /**
   * Validates the TcpLoggingConfiguration model's fields and constraints.
   *
   * @param tcpLoggingConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(TcpLoggingConfiguration tcpLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(tcpLoggingConfiguration.getHost())
      )
      .add(
        new NumericValidator<Long>("port").min(1L).max(65535L).required().validate(tcpLoggingConfiguration.getPort())
      )
      .aggregate();
  }
}
