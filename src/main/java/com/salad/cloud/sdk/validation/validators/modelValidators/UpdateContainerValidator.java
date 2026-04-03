package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.UpdateContainer;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for UpdateContainer model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class UpdateContainerValidator extends AbstractModelValidator<UpdateContainer> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public UpdateContainerValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public UpdateContainerValidator() {}

  /**
   * Validates the UpdateContainer model's fields and constraints.
   *
   * @param updateContainer The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(UpdateContainer updateContainer) {
    return new ViolationAggregator()
      .add(
        new ListValidator<String>("command")
          .maxLength(100)
          .itemValidator(new StringValidator().minLength(1).maxLength(1024).pattern("^.*$").required())
          .optional()
          .validate(updateContainer.getCommand())
      )
      .add(
        new StringValidator("image")
          .minLength(1)
          .maxLength(1024)
          .pattern("^.*$")
          .optional()
          .validate(updateContainer.getImage())
      )
      .add(new UpdateContainerLoggingValidator("logging").optional().validate(updateContainer.getLogging()))
      .add(
        new ContainerRegistryAuthenticationValidator("registryAuthentication")
          .optional()
          .validate(updateContainer.getRegistryAuthentication())
      )
      .add(new ContainerResourceUpdateSchemaValidator("resources").optional().validate(updateContainer.getResources()))
      .aggregate();
  }
}
