# InferenceEndpointsService

A list of all methods in the `InferenceEndpointsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                           |
| :-------------------------------------------------------- | :------------------------------------ |
| [listInferenceEndpoints](#listinferenceendpoints)         | Lists inference endpoints.            |
| [getInferenceEndpoint](#getinferenceendpoint)             | Gets an inference endpoint.           |
| [listInferenceEndpointJobs](#listinferenceendpointjobs)   | Lists inference endpoint jobs.        |
| [createInferenceEndpointJob](#createinferenceendpointjob) | Creates a new inference endpoint job. |
| [getInferenceEndpointJob](#getinferenceendpointjob)       | Gets an inference endpoint job.       |
| [cancelInferenceEndpointJob](#cancelinferenceendpointjob) | Cancels an inference endpoint job.    |

## listInferenceEndpoints

Lists inference endpoints.

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints`

**Parameters**

| Name              | Type                                                                              | Required | Description                                                                                                                                                                                                                                         |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName  | String                                                                            | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| requestParameters | [ListInferenceEndpointsParameters](../models/ListInferenceEndpointsParameters.md) | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

**Return Type**

`InferenceEndpointList`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointList;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val requestParameters: ListInferenceEndpointsParameters = ListInferenceEndpointsParameters.builder()
			.page(1L)
			.pageSize(1L)
			.build();

    val response: InferenceEndpointList = saladCloudSdk.inferenceEndpoints.listInferenceEndpoints("acme-corp", requestParameters);

    println(response);
}
```

## getInferenceEndpoint

Gets an inference endpoint.

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}`

**Parameters**

| Name                  | Type   | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | String | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |

**Return Type**

`InferenceEndpoint`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpoint;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: InferenceEndpoint = saladCloudSdk.inferenceEndpoints.getInferenceEndpoint("acme-corp", "transcribe");

    println(response);
}
```

## listInferenceEndpointJobs

Lists inference endpoint jobs.

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs`

**Parameters**

| Name                  | Type                                                                                    | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :-------------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | String                                                                                  | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | String                                                                                  | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |
| requestParameters     | [ListInferenceEndpointJobsParameters](../models/ListInferenceEndpointJobsParameters.md) | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

**Return Type**

`InferenceEndpointJobList`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;
import com.salad.cloud.sdk.models.ListInferenceEndpointJobsParameters;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val requestParameters: ListInferenceEndpointJobsParameters = ListInferenceEndpointJobsParameters.builder()
			.page(1L)
			.pageSize(1L)
			.build();

    val response: InferenceEndpointJobList = saladCloudSdk.inferenceEndpoints.listInferenceEndpointJobs("acme-corp", "transcribe", requestParameters);

    println(response);
}
```

## createInferenceEndpointJob

Creates a new inference endpoint job.

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs`

**Parameters**

| Name                       | Type                                                                  | Required | Description                                                                                                                                                                                                                                         |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName           | String                                                                | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName      | String                                                                | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |
| createInferenceEndpointJob | [CreateInferenceEndpointJob](../models/CreateInferenceEndpointJob.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`InferenceEndpointJob`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJob;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val createInferenceEndpointJob: CreateInferenceEndpointJob = CreateInferenceEndpointJob.builder()
			.input(Object())
			.metadata(Object())
			.webhookUrl("webhook_url")
			.build();

    val response: InferenceEndpointJob = saladCloudSdk.inferenceEndpoints.createInferenceEndpointJob("acme-corp", "transcribe", createInferenceEndpointJob);

    println(response);
}
```

## getInferenceEndpointJob

Gets an inference endpoint job.

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}`

**Parameters**

| Name                   | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | String | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |
| inferenceEndpointJobId | String | ✅       | The inference endpoint job identifier.                                                                                                                                                                                                              |

**Return Type**

`InferenceEndpointJob`

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJob;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: InferenceEndpointJob = saladCloudSdk.inferenceEndpoints.getInferenceEndpointJob("acme-corp", "transcribe", "2fc459a1-1c09-4a34-ade7-54d03fc51d6a");

    println(response);
}
```

## cancelInferenceEndpointJob

Cancels an inference endpoint job.

- HTTP Method: `DELETE`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}`

**Parameters**

| Name                   | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | String | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |
| inferenceEndpointJobId | String | ✅       | The inference endpoint job identifier.                                                                                                                                                                                                              |

**Example Usage Code Snippet**

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.inferenceEndpoints.cancelInferenceEndpointJob("acme-corp", "transcribe", "2fc459a1-1c09-4a34-ade7-54d03fc51d6a");
}
```
