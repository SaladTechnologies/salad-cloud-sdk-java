# InferenceEndpointsService

A list of all methods in the `InferenceEndpointsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                                    |
| :-------------------------------------------------------- | :--------------------------------------------- |
| [listInferenceEndpoints](#listinferenceendpoints)         | Gets the list of inference endpoints           |
| [getInferenceEndpoint](#getinferenceendpoint)             | Gets an inference endpoint                     |
| [getInferenceEndpointJobs](#getinferenceendpointjobs)     | Retrieves a list of an inference endpoint jobs |
| [createInferenceEndpointJob](#createinferenceendpointjob) | Creates a new job                              |
| [getInferenceEndpointJob](#getinferenceendpointjob)       | Retrieves a job in an inference endpoint       |
| [deleteInferenceEndpointJob](#deleteinferenceendpointjob) | Deletes an inference endpoint job              |

## listInferenceEndpoints

Gets the list of inference endpoints

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/inference-endpoints`

**Parameters**

| Name              | Type                                                                              | Required | Description                                                                                                                                                                                                                                         |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName  | String                                                                            | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| requestParameters | [ListInferenceEndpointsParameters](../models/ListInferenceEndpointsParameters.md) | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

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
      .page(1536623748L)
      .pageSize(41L)
      .build();

    InferenceEndpointsList response = saladCloudSdk.inferenceEndpoints.listInferenceEndpoints(
      "r98kinnaq6opnq-td84vb3q9zv3k2ki3jzct2pf06rygg23yz",
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

| Name                  | Type   | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | String | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |

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

    InferenceEndpoint response = saladCloudSdk.inferenceEndpoints.getInferenceEndpoint(
      "cx2mv031v8afyh5y7ht26t-sfc4u7-dhjnxb2hbrz-ipttu1m2vc",
      "inference_endpoint_name"
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

| Name                  | Type                                                                                  | Required | Description                                                                                                                                                                                                                                         |
| :-------------------- | :------------------------------------------------------------------------------------ | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName      | String                                                                                | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName | String                                                                                | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| requestParameters     | [GetInferenceEndpointJobsParameters](../models/GetInferenceEndpointJobsParameters.md) | ❌       | Request Parameters Object                                                                                                                                                                                                                           |

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
      .page(1228703779L)
      .pageSize(80L)
      .build();

    InferenceEndpointJobList response = saladCloudSdk.inferenceEndpoints.getInferenceEndpointJobs(
      "pk05fdmxk23ipxt6vd6e",
      "inference_endpoint_name",
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

| Name                       | Type                                                                  | Required | Description                                                                                                                                                                                                                                         |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName           | String                                                                | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName      | String                                                                | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| createInferenceEndpointJob | [CreateInferenceEndpointJob](../models/CreateInferenceEndpointJob.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

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

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpoints.createInferenceEndpointJob(
      "pk05fdmxk23ipxt6vd6e",
      "inference_endpoint_name",
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

| Name                   | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | String | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| inferenceEndpointJobId | String | ✅       | The unique job id                                                                                                                                                                                                                                   |

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
      "igqfe6b1d0c-0auqqph3bt-7bft4c1m95idut36tc-x7mo2nsh7uoln",
      "inference_endpoint_name",
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

| Name                   | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName       | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| inferenceEndpointName  | String | ✅       | The unique inference endpoint name                                                                                                                                                                                                                  |
| inferenceEndpointJobId | String | ✅       | The unique job id                                                                                                                                                                                                                                   |

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
      "igqfe6b1d0c-0auqqph3bt-7bft4c1m95idut36tc-x7mo2nsh7uoln",
      "inference_endpoint_name",
      "inference_endpoint_job_id"
    );
  }
}

```
