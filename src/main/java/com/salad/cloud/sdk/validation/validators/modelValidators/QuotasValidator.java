package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Quotas;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

public class QuotasValidator extends AbstractModelValidator<Quotas> {

  public QuotasValidator(String fieldName) {
    super(fieldName);
  }

  public QuotasValidator() {}

  @Override
  protected Violation[] validateModel(Quotas quotas) {
    return new ViolationAggregator()
      .add(
        new ContainerGroupsQuotasValidator("containerGroupsQuotas")
          .required()
          .validate(quotas.getContainerGroupsQuotas())
      )
      .aggregate();
  }
}
