package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.GpuClass;
import com.salad.cloud.sdk.models.GpuClassesList;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for GpuClassesList model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GpuClassesListValidator extends AbstractModelValidator<GpuClassesList> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GpuClassesListValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GpuClassesListValidator() {}

  /**
   * Validates the GpuClassesList model's fields and constraints.
   *
   * @param gpuClassesList The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GpuClassesList gpuClassesList) {
    return new ViolationAggregator()
      .add(
        new ListValidator<GpuClass>("items")
          .maxLength(100)
          .itemValidator(new GpuClassValidator().required())
          .required()
          .validate(gpuClassesList.getItems())
      )
      .aggregate();
  }
}
