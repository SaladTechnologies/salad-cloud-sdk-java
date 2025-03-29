package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGcr;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerRegistryAuthenticationGcpGcrValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationGcpGcr> {

  public ContainerRegistryAuthenticationGcpGcrValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationGcpGcrValidator() {}

  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationGcpGcr containerRegistryAuthenticationGcpGcr) {
    return new ViolationAggregator()
      .add(
        new StringValidator("serviceKey")
          .minLength(1)
          .maxLength(10000)
          .required()
          .validate(containerRegistryAuthenticationGcpGcr.getServiceKey())
      )
      .aggregate();
  }
}
