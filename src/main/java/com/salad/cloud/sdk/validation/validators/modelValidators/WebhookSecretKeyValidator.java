package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.WebhookSecretKey;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

public class WebhookSecretKeyValidator extends AbstractModelValidator<WebhookSecretKey> {

  public WebhookSecretKeyValidator(String fieldName) {
    super(fieldName);
  }

  public WebhookSecretKeyValidator() {}

  @Override
  protected Violation[] validateModel(WebhookSecretKey webhookSecretKey) {
    return new ViolationAggregator()
      .add(
        new StringValidator("secretKey")
          .minLength(44)
          .maxLength(172)
          .pattern("^[+/=0-9A-Za-z]{44,172}$")
          .required()
          .validate(webhookSecretKey.getSecretKey())
      )
      .aggregate();
  }
}
