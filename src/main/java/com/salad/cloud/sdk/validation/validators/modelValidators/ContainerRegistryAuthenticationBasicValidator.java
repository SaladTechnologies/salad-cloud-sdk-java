package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationBasic;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerRegistryAuthenticationBasicValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationBasic> {

  public ContainerRegistryAuthenticationBasicValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationBasicValidator() {}

  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationBasic containerRegistryAuthenticationBasic) {
    return new ViolationAggregator()
      .add(
        new StringValidator("username")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationBasic.getUsername())
      )
      .add(
        new StringValidator("password")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationBasic.getPassword())
      )
      .aggregate();
  }
}
