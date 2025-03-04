# WebhookSecretKeyService

A list of all methods in the `WebhookSecretKeyService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                    |
| :------------------------------------------------ | :----------------------------- |
| [getWebhookSecretKey](#getwebhooksecretkey)       | Gets the webhook secret key    |
| [updateWebhookSecretKey](#updatewebhooksecretkey) | Updates the webhook secret key |

## getWebhookSecretKey

Gets the webhook secret key

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/webhook-secret-key`

**Parameters**

| Name             | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |

**Return Type**

`WebhookSecretKey`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WebhookSecretKey;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: WebhookSecretKey = saladCloudSdk.webhookSecretKey.getWebhookSecretKey("acme-corp");

    println(response);
}
```

## updateWebhookSecretKey

Updates the webhook secret key

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/webhook-secret-key`

**Parameters**

| Name             | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |

**Return Type**

`WebhookSecretKey`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WebhookSecretKey;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: WebhookSecretKey = saladCloudSdk.webhookSecretKey.updateWebhookSecretKey("acme-corp");

    println(response);
}
```
