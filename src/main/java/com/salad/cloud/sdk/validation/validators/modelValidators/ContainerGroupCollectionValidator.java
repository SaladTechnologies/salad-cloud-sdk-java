package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for ContainerGroupCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupCollectionValidator extends AbstractModelValidator<ContainerGroupCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupCollectionValidator() {}

  /**
   * Validates the ContainerGroupCollection model's fields and constraints.
   *
   * @param containerGroupCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupCollection containerGroupCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroup>("items")
          .maxLength(100)
          .itemValidator(new ContainerGroupValidator().required())
          .required()
          .validate(containerGroupCollection.getItems())
      )
      .aggregate();
  }
}
