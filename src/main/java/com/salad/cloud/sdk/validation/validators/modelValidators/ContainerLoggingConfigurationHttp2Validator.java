package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp2;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerLoggingConfigurationHttp2Validator
  extends AbstractModelValidator<ContainerLoggingConfigurationHttp2> {

  public ContainerLoggingConfigurationHttp2Validator(String fieldName) {
    super(fieldName);
  }

  public ContainerLoggingConfigurationHttp2Validator() {}

  @Override
  protected Violation[] validateModel(ContainerLoggingConfigurationHttp2 containerLoggingConfigurationHttp2) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerLoggingConfigurationHttp2.getHost())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerLoggingConfigurationHttp2.getPort())
      )
      .add(
        new StringValidator("user")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp2.getUser())
      )
      .add(
        new StringValidator("password")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp2.getPassword())
      )
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerLoggingConfigurationHttp2.getPath())
      )
      .add(
        new ListValidator<ContainerLoggingHttpHeader>("headers")
          .maxLength(1000)
          .itemValidator(new ContainerLoggingHttpHeaderValidator().required())
          .optional()
          .validate(containerLoggingConfigurationHttp2.getHeaders())
      )
      .aggregate();
  }
}
