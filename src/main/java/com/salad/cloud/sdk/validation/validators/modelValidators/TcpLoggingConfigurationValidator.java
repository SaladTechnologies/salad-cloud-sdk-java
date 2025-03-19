package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.TcpLoggingConfiguration;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class TcpLoggingConfigurationValidator extends AbstractModelValidator<TcpLoggingConfiguration> {

  public TcpLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public TcpLoggingConfigurationValidator() {}

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
