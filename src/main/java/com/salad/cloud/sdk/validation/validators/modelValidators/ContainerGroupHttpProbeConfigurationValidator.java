package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroupHttpProbeConfiguration;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for ContainerGroupHttpProbeConfiguration model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ContainerGroupHttpProbeConfigurationValidator
  extends AbstractModelValidator<ContainerGroupHttpProbeConfiguration> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ContainerGroupHttpProbeConfigurationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ContainerGroupHttpProbeConfigurationValidator() {}

  /**
   * Validates the ContainerGroupHttpProbeConfiguration model's fields and constraints.
   *
   * @param containerGroupHttpProbeConfiguration The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ContainerGroupHttpProbeConfiguration containerGroupHttpProbeConfiguration) {
    return new ViolationAggregator()
      .add(
        new ListValidator<ContainerGroupProbeHttpHeader>("headers")
          .minLength(1)
          .maxLength(50)
          .itemValidator(new ContainerGroupProbeHttpHeaderValidator().required())
          .required()
          .validate(containerGroupHttpProbeConfiguration.getHeaders())
      )
      .add(
        new StringValidator("path")
          .minLength(1)
          .maxLength(2048)
          .pattern("^.*$")
          .required()
          .validate(containerGroupHttpProbeConfiguration.getPath())
      )
      .add(
        new NumericValidator<Long>("port")
          .min(0L)
          .max(65536L)
          .required()
          .validate(containerGroupHttpProbeConfiguration.getPort())
      )
      .aggregate();
  }
}
