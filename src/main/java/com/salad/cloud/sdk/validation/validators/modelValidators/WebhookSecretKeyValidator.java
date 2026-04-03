package com.salad.cloud.sdk.validation.validators.modelValidators;

import com.salad.cloud.sdk.models.WebhookSecretKey;
import com.salad.cloud.sdk.validation.Violation;
import com.salad.cloud.sdk.validation.ViolationAggregator;
import com.salad.cloud.sdk.validation.validators.StringValidator;

/**
 * Validator implementation for WebhookSecretKey model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class WebhookSecretKeyValidator extends AbstractModelValidator<WebhookSecretKey> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public WebhookSecretKeyValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public WebhookSecretKeyValidator() {}

  /**
   * Validates the WebhookSecretKey model's fields and constraints.
   *
   * @param webhookSecretKey The model instance to validate
   * @return Array of violations found during validation
   */
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
