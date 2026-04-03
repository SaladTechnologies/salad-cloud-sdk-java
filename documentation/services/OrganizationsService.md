# OrganizationsService

A list of all methods in the `OrganizationsService` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description                                          |
| :---------------------------------------- | :--------------------------------------------------- |
| [getCpuAvailability](#getcpuavailability) | Gets the CPU availability for the given organization |
| [getGpuAvailability](#getgpuavailability) | Gets the GPU availability for the given organization |

## getCpuAvailability

Gets the CPU availability for the given organization

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/availability/sce-cpu-availability`

**Parameters**

| Name                     | Type                                                              | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :---------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String                                                            | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| cpuAvailabilityPrototype | [CpuAvailabilityPrototype](../models/CpuAvailabilityPrototype.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`CpuAvailability`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.CpuAvailability;
import com.salad.cloud.sdk.models.CpuAvailabilityPrototype;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<CountryCode> countryCodesList = Arrays.asList(CountryCode.AF);

    CpuAvailabilityPrototype cpuAvailabilityPrototype = CpuAvailabilityPrototype.builder()
      .countryCodes(countryCodesList)
      .cpu(4L)
      .memory(8192L)
      .storageAmount(1000000000L)
      .build();

    CpuAvailability response = saladCloudSdk.organizations.getCpuAvailability("acme-corp", cpuAvailabilityPrototype);

    System.out.println(response);
  }
}

```

## getGpuAvailability

Gets the GPU availability for the given organization

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/availability/sce-gpu-availability`

**Parameters**

| Name                     | Type                                                              | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :---------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String                                                            | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| gpuAvailabilityPrototype | [GpuAvailabilityPrototype](../models/GpuAvailabilityPrototype.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`GpuAvailability`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.GpuAvailability;
import com.salad.cloud.sdk.models.GpuAvailabilityPrototype;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<CountryCode> countryCodesList = Arrays.asList(CountryCode.AF);

    List<String> gpuClassesList = Arrays.asList("gpu_classes");

    GpuAvailabilityPrototype gpuAvailabilityPrototype = GpuAvailabilityPrototype.builder()
      .countryCodes(countryCodesList)
      .cpu(4L)
      .gpuClasses(gpuClassesList)
      .memory(8192L)
      .storageAmount(1000000000L)
      .build();

    GpuAvailability response = saladCloudSdk.organizations.getGpuAvailability("acme-corp", gpuAvailabilityPrototype);

    System.out.println(response);
  }
}

```
