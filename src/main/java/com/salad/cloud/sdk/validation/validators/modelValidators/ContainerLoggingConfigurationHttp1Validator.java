package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp1;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerLoggingConfigurationHttp1Validator
  extends AbstractModelValidator<ContainerLoggingConfigurationHttp1> {

  public ContainerLoggingConfigurationHttp1Validator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingConfigurationHttp1Validator() {}

  @Override
  protected Violation[] validateModel(ContainerLoggingConfigurationHttp1 containerLoggingConfigurationHttp1) {
    return new ViolationAggregator()
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
        new ListValidator<ContainerLoggingHttpHeader>("headers")
          .maxLength(1000)
          .itemValidator(new ContainerLoggingHttpHeaderValidator().required())
          .optional()
          .validate(containerLoggingConfigurationHttp1.getHeaders())
      )
      .add(
        new StringValidator("user")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp1.getUser())
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
      .aggregate();
  }
}
