package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationAwsEcr;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerRegistryAuthenticationAwsEcrValidator
  extends AbstractModelValidator<ContainerRegistryAuthenticationAwsEcr> {

  public ContainerRegistryAuthenticationAwsEcrValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerRegistryAuthenticationAwsEcrValidator() {}

  @Override
  protected Violation[] validateModel(ContainerRegistryAuthenticationAwsEcr containerRegistryAuthenticationAwsEcr) {
    return new ViolationAggregator()
      .add(
        new StringValidator("accessKeyId")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationAwsEcr.getAccessKeyId())
      )
      .add(
        new StringValidator("secretAccessKey")
          .minLength(1)
          .maxLength(10000)
          .pattern("^.*$")
          .required()
          .validate(containerRegistryAuthenticationAwsEcr.getSecretAccessKey())
      )
      .aggregate();
  }
}
