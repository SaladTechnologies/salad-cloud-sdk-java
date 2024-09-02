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

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WebhookSecretKey;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    WebhookSecretKey response = saladCloudSdk.webhookSecretKeyService.getWebhookSecretKey(
      "dyxdaqq1t3iwwpawdlk-78rt9bh26smkuf3v0nd2ropp"
    );

    System.out.println(response);
  }
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

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WebhookSecretKey;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    WebhookSecretKey response = saladCloudSdk.webhookSecretKeyService.updateWebhookSecretKey(
      "dyxdaqq1t3iwwpawdlk-78rt9bh26smkuf3v0nd2ropp"
    );

    System.out.println(response);
  }
}

```
