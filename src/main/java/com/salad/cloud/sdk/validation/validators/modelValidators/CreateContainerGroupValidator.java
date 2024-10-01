package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.CreateContainerGroup;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class CreateContainerGroupValidator extends AbstractModelValidator<CreateContainerGroup> {

  public CreateContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  public CreateContainerGroupValidator() {}

  @Override
  protected Violation[] validateModel(CreateContainerGroup createContainerGroup) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(63)
          .pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$")
          .validate(createContainerGroup.getName())
      )
      .add(new CreateContainerValidator("container").validate(createContainerGroup.getContainer()))
      .add(new NumericValidator<Long>("replicas").min(0L).max(250L).validate(createContainerGroup.getReplicas()))
      .add(
        new StringValidator("displayName")
          .minLength(2)
          .maxLength(63)
          .pattern("^[ ,-.0-9A-Za-z]+$")
          .validate(createContainerGroup.getDisplayName())
      )
      .add(
        new ListValidator<CountryCode>("countryCodes")
          .minLength(1)
          .maxLength(500)
          .validate(createContainerGroup.getCountryCodes())
      )
      .add(
        new ContainerGroupQueueConnectionValidator("queueConnection")
          .validate(createContainerGroup.getQueueConnection())
      )
      .aggregate();
  }
}
