# QuotasService

A list of all methods in the `QuotasService` service. Click on the method name to view detailed information about that method.

| Methods                 | Description                  |
| :---------------------- | :--------------------------- |
| [getQuotas](#getquotas) | Gets the organization quotas |

## getQuotas

Gets the organization quotas

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/quotas`

**Parameters**

| Name             | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |

**Return Type**

`Quotas`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.Quotas;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    Quotas response = saladCloudSdk.quotasService.getQuotas("oecson4k2eclxr");

    System.out.println(response);
  }
}

```
