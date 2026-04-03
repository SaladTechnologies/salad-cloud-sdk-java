package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstanceCollection;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;

/**
 * Validator implementation for ContainerGroupInstanceCollection model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupInstanceCollectionValidator
  extends AbstractModelValidator<ContainerGroupInstanceCollection> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupInstanceCollectionValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupInstanceCollectionValidator() {}

  /**
   * Validates the ContainerGroupInstanceCollection model's fields and constraints.
   *
   * @param containerGroupInstanceCollection The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupInstanceCollection containerGroupInstanceCollection) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroupInstance>("instances")
          .maxLength(1000)
          .itemValidator(new ContainerGroupInstanceValidator().required())
          .required()
          .validate(containerGroupInstanceCollection.getInstances())
      )
      .aggregate();
  }
}
