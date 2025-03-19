package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerHttpLoggingConfiguration;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerHttpLoggingConfigurationValidator
  extends AbstractModelValidator<ContainerHttpLoggingConfiguration> {

  public ContainerHttpLoggingConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerHttpLoggingConfigurationValidator() {}

  @Override
  protected Violation[] validateModel(ContainerHttpLoggingConfiguration containerHttpLoggingConfiguration) {
    return new ViolationAggregator()
      .add(
        new StringValidator("host")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .required()
          .validate(containerHttpLoggingConfiguration.getHost())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(1L)
          .max(65535L)
          .required()
          .validate(containerHttpLoggingConfiguration.getPort())
      )
      .add(
        new ListValidator<ContainerLoggingHttpHeader>("headers")
          .maxLength(1000)
          .itemValidator(new ContainerLoggingHttpHeaderValidator().required())
          .optional()
          .validate(containerHttpLoggingConfiguration.getHeaders())
      )
      .add(
        new StringValidator("user")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerHttpLoggingConfiguration.getUser())
      )
      .add(
        new StringValidator("password")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerHttpLoggingConfiguration.getPassword())
      )
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(1000)
          .pattern("^.*$")
          .optional()
          .validate(containerHttpLoggingConfiguration.getPath())
      )
      .aggregate();
  }
}
