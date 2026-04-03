package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuAvailabilityPrototype;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for GpuAvailabilityPrototype model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GpuAvailabilityPrototypeValidator extends AbstractModelValidator<GpuAvailabilityPrototype> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GpuAvailabilityPrototypeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GpuAvailabilityPrototypeValidator() {}

  /**
   * Validates the GpuAvailabilityPrototype model's fields and constraints.
   *
   * @param gpuAvailabilityPrototype The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GpuAvailabilityPrototype gpuAvailabilityPrototype) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("gpuClasses")
          .minLength(1)
          .required()
          .validate(gpuAvailabilityPrototype.getGpuClasses())
      )
      .aggregate();
  }
}
