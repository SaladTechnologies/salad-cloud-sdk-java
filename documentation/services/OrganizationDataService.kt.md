# OrganizationDataService

A list of all methods in the `OrganizationDataService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description          |
| :-------------------------------- | :------------------- |
| [listGpuClasses](#listgpuclasses) | List the GPU Classes |

## listGpuClasses

List the GPU Classes

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/gpu-classes`

**Parameters**

| Name             | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |

**Return Type**

`GpuClassesList`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.GpuClassesList;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: GpuClassesList = saladCloudSdk.organizationData.listGpuClasses("acme-corp");

    println(response);
}
```
