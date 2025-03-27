package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGar;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerRegistryAuthenticationGcpGarValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationGcpGar> {

  public ContainerRegistryAuthenticationGcpGarValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationGcpGarValidator() {}

  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationGcpGar containerRegistryAuthenticationGcpGar) {
    return new ViolationAggregator()
      .add(
        new StringValidator("serviceKey")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationGcpGar.getServiceKey())
      )
      .aggregate();
  }
}
