package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClassPrice;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for GpuClassPrice model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GpuClassPriceValidator extends AbstractModelValidator<GpuClassPrice> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GpuClassPriceValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GpuClassPriceValidator() {}

  /**
   * Validates the GpuClassPrice model's fields and constraints.
   *
   * @param gpuClassPrice The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GpuClassPrice gpuClassPrice) {
    return new ViolationAggregator()
      .add(
        new StringValidator("price")
          .minLength(1)
          .maxLength(20)
          .pattern("^.*$")
          .required()
          .validate(gpuClassPrice.getPrice())
      )
      .aggregate();
  }
}
