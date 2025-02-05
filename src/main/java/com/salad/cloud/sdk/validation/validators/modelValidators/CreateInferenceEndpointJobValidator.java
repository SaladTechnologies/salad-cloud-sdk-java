package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class CreateInferenceEndpointJobValidator extends AbstractModelValidator<CreateInferenceEndpointJob> {

  public CreateInferenceEndpointJobValidator(String fieldName) {
    super(fieldName);
  }

  public CreateInferenceEndpointJobValidator() {}

  @Override
  protected Violation[] validateModel(CreateInferenceEndpointJob createInferenceEndpointJob) {
    return new ViolationAggregator()
      .add(new StringValidator("webhook").maxLength(2000).optional().validate(createInferenceEndpointJob.getWebhook()))
      .aggregate();
  }
}
