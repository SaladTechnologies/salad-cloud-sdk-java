# InferenceEndpointsService

A list of all methods in the `InferenceEndpointsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                           |
| :-------------------------------------------------------- | :------------------------------------ |
| [listInferenceEndpoints](#listinferenceendpoints)         | Lists inference endpoints.            |
| [getInferenceEndpoint](#getinferenceendpoint)             | Gets an inference endpoint.           |
| [listInferenceEndpointJobs](#listinferenceendpointjobs)   | Lists inference endpoint jobs.        |
| [createInferenceEndpointJob](#createinferenceendpointjob) | Creates a new inference endpoint job. |
| [getInferenceEndpointJob](#getinferenceendpointjob)       | Gets an inference endpoint job.       |
| [deleteInferenceEndpointJob](#deleteinferenceendpointjob) | Cancels an inference endpoint job.    |

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

`InferenceEndpointCollection`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointCollection;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ListInferenceEndpointsParameters requestParameters = ListInferenceEndpointsParameters
      .builder()
      .page(1L)
      .pageSize(1L)
      .build();

    InferenceEndpointCollection response = saladCloudSdk.inferenceEndpoints.listInferenceEndpoints(
      "acme-corp",
      requestParameters
    );

    System.out.println(response);
  }
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

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpoint;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    InferenceEndpoint response = saladCloudSdk.inferenceEndpoints.getInferenceEndpoint("acme-corp", "transcribe");

    System.out.println(response);
  }
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

`InferenceEndpointJobCollection`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJobCollection;
import com.salad.cloud.sdk.models.ListInferenceEndpointJobsParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ListInferenceEndpointJobsParameters requestParameters = ListInferenceEndpointJobsParameters
      .builder()
      .page(1L)
      .pageSize(1L)
      .build();

    InferenceEndpointJobCollection response = saladCloudSdk.inferenceEndpoints.listInferenceEndpointJobs(
      "acme-corp",
      "transcribe",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## createInferenceEndpointJob

Creates a new inference endpoint job.

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs`

**Parameters**

| Name                          | Type                                                                        | Required | Description                                                                                                                                                                                                                                         |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName              | String                                                                      | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName         | String                                                                      | ✅       | The inference endpoint name.                                                                                                                                                                                                                        |
| inferenceEndpointJobPrototype | [InferenceEndpointJobPrototype](../models/InferenceEndpointJobPrototype.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`InferenceEndpointJob`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobPrototype;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    InferenceEndpointJobPrototype inferenceEndpointJobPrototype = InferenceEndpointJobPrototype
      .builder()
      .input(new Object())
      .metadata(new Object())
      .webhookUrl("https://webhook.example.com/events")
      .build();

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpoints.createInferenceEndpointJob(
      "acme-corp",
      "transcribe",
      inferenceEndpointJobPrototype
    );

    System.out.println(response);
  }
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

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJob;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpoints.getInferenceEndpointJob(
      "acme-corp",
      "transcribe",
      "2fc459a1-1c09-4a34-ade7-54d03fc51d6a"
    );

    System.out.println(response);
  }
}

```

## deleteInferenceEndpointJob

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

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.inferenceEndpoints.deleteInferenceEndpointJob(
      "acme-corp",
      "transcribe",
      "2fc459a1-1c09-4a34-ade7-54d03fc51d6a"
    );
  }
}

```
