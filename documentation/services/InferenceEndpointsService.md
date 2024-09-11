# InferenceEndpointsService

A list of all methods in the `InferenceEndpointsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                                    |
| :-------------------------------------------------------- | :--------------------------------------------- |
| [listInferenceEndpoints](#listinferenceendpoints)         | Gets the list of all inference endpoints       |
| [getInferenceEndpoint](#getinferenceendpoint)             | Gets an inference endpoint                     |
| [getInferenceEndpointJobs](#getinferenceendpointjobs)     | Retrieves a list of an inference endpoint jobs |
| [createInferenceEndpointJob](#createinferenceendpointjob) | Creates a new job                              |
| [getInferenceEndpointJob](#getinferenceendpointjob)       | Retrieves a job in an inference endpoint       |
| [deleteInferenceEndpointJob](#deleteinferenceendpointjob) | Deletes an inference endpoint job              |

## listInferenceEndpoints

Gets the list of all inference endpoints

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints`

**Parameters**

| Name              | Type                                                                                | Required | Description                                                                                                                                                                                                                                         |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName  | `String`                                                                            | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| requestParameters | `[ListInferenceEndpointsParameters](../models/ListInferenceEndpointsParameters.md)` | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

**Return Type**

`InferenceEndpointsList`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointsList;
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
      .page(756148233L)
      .pageSize(66L)
      .build();

    InferenceEndpointsList response = saladCloudSdk.inferenceEndpointsService.listInferenceEndpoints(
      "wg1umdxtc9fte8osib-e-5ux2vsmrhjjt13u7q3pryxxnm",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## getInferenceEndpoint

Gets an inference endpoint

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}`

**Parameters**

| Name                  | Type     | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | `String` | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | `String` | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |

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

    InferenceEndpoint response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpoint(
      "uzp1dyfm2yp4-lxa27tl0fwms3fu3myo74a99jr6ouv4w8",
      "aute Ut reprehenderit occaecat sed"
    );

    System.out.println(response);
  }
}

```

## getInferenceEndpointJobs

Retrieves a list of an inference endpoint jobs

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs`

**Parameters**

| Name                  | Type                                                                                    | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :-------------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | `String`                                                                                | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | `String`                                                                                | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| requestParameters     | `[GetInferenceEndpointJobsParameters](../models/GetInferenceEndpointJobsParameters.md)` | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

**Return Type**

`InferenceEndpointJobList`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.GetInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    GetInferenceEndpointJobsParameters requestParameters = GetInferenceEndpointJobsParameters
      .builder()
      .page(1653138765L)
      .pageSize(76L)
      .build();

    InferenceEndpointJobList response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpointJobs(
      "trzfoq1p77wk9jgwxjp56dzbnwtbgowklqt1wsbe00",
      "ut officia ut",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## createInferenceEndpointJob

Creates a new job

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs`

**Parameters**

| Name                       | Type                                                                    | Required | Description                                                                                                                                                                                                                                         |
| :------------------------- | :---------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName           | `String`                                                                | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName      | `String`                                                                | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| createInferenceEndpointJob | `[CreateInferenceEndpointJob](../models/CreateInferenceEndpointJob.md)` | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`InferenceEndpointJob`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJob;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    CreateInferenceEndpointJob createInferenceEndpointJob = CreateInferenceEndpointJob
      .builder()
      .input(new Object())
      .metadata(new Object())
      .webhook("webhook")
      .build();

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpointsService.createInferenceEndpointJob(
      "trzfoq1p77wk9jgwxjp56dzbnwtbgowklqt1wsbe00",
      "ut officia ut",
      createInferenceEndpointJob
    );

    System.out.println(response);
  }
}

```

## getInferenceEndpointJob

Retrieves a job in an inference endpoint

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}`

**Parameters**

| Name                   | Type     | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | `String` | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | `String` | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| inferenceEndpointJobId | `String` | ✅       | The unique job id                                                                                                                                                                                                                                   |

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

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpointJob(
      "b7tj9",
      "sed eu labore",
      "inference_endpoint_job_id"
    );

    System.out.println(response);
  }
}

```

## deleteInferenceEndpointJob

Deletes an inference endpoint job

- HTTP Method: `DELETE`
- Endpoint: `/organizations/{organization_name}/inference-endpoints/{inference_endpoint_name}/jobs/{inference_endpoint_job_id}`

**Parameters**

| Name                   | Type     | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | `String` | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | `String` | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| inferenceEndpointJobId | `String` | ✅       | The unique job id                                                                                                                                                                                                                                   |

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

    saladCloudSdk.inferenceEndpointsService.deleteInferenceEndpointJob(
      "b7tj9",
      "sed eu labore",
      "inference_endpoint_job_id"
    );
  }
}

```
