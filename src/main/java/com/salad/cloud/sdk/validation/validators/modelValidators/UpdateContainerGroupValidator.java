package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.UpdateContainerGroup;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.ListValidator;
import com.salad.cloud.sdk.validation.validators.NumericValidator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class UpdateContainerGroupValidator extends AbstractModelValidator<UpdateContainerGroup> {

  public UpdateContainerGroupValidator(String fieldName) {
    super(fieldName);
  }

  public UpdateContainerGroupValidator() {}

  @Override
  protected Violation[] validateModel(UpdateContainerGroup updateContainerGroup) {
    return new ViolationAggregator()
      .add(
        new StringValidator("displayName").minLength(2).maxLength(63).pattern("^[ ,-.0-9A-Za-z]+$"),
        updateContainerGroup.getDisplayName()
      )
      .add(new UpdateContainerValidator("container"), updateContainerGroup.getContainer())
      .add(new NumericValidator<Long>("replicas").min(0L).max(250L), updateContainerGroup.getReplicas())
      .add(
        new ListValidator<CountryCode>("countryCodes").minLength(1).maxLength(500),
        updateContainerGroup.getCountryCodes()
      )
      .aggregate();
  }
}
