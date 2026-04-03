package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.Quotas;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;

/**
 * Validator implementation for Quotas model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class QuotasValidator extends AbstractModelValidator<Quotas> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public QuotasValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public QuotasValidator() {}

  /**
   * Validates the Quotas model's fields and constraints.
   *
   * @param quotas The model instance to validate
   * @return Array of violations found during validation
   */
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
