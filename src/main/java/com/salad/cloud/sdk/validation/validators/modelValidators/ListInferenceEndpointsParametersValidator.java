package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;

/**
 * Validator implementation for ListInferenceEndpointsParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ListInferenceEndpointsParametersValidator
  extends AbstractModelValidator<ListInferenceEndpointsParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ListInferenceEndpointsParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ListInferenceEndpointsParametersValidator() {}

  /**
   * Validates the ListInferenceEndpointsParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ListInferenceEndpointsParameters requestParameters) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("page").min(1L).max(2147483647L).optional().validate(requestParameters.getPage()))
      .add(
        new NumericValidator<Long>("pageSize").min(1L).max(100L).optional().validate(requestParameters.getPageSize())
      )
      .aggregate();
  }
}
