package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class ContainerGroupValidator extends AbstractModelValidator<ContainerGroup> {

  public ContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerGroupValidator() {}

  @Override
  protected Violation[] validateModel(ContainerGroup containerGroup) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name").minLength(2).maxLength(63).pattern("^[a-z][a-z0-9-]{0,61}[a-z0-9]$"),
        containerGroup.getName()
      )
      .add(
        new StringValidator("displayName").minLength(2).maxLength(63).pattern("^[ ,-.0-9A-Za-z]+$"),
        containerGroup.getDisplayName()
      )
      .add(new ContainerValidator("container"), containerGroup.getContainer())
      .add(new NumericValidator<Long>("replicas").min(0L).max(100L), containerGroup.getReplicas())
      .add(new NumericValidator<Long>("version").min(1L), containerGroup.getVersion())
      .add(new ListValidator<CountryCode>("countryCodes").minLength(1).maxLength(500), containerGroup.getCountryCodes())
      .add(new ContainerGroupQueueConnectionValidator("queueConnection"), containerGroup.getQueueConnection())
      .aggregate();
  }
}
