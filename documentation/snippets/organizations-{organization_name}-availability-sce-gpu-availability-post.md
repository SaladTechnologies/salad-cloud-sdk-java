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

    List<String> gpuClassesList = Arrays.asList("gpu_classes");

    List<CountryCode> countryCodesList = Arrays.asList(CountryCode.AF);

    GpuAvailabilityPrototype gpuAvailabilityPrototype = GpuAvailabilityPrototype.builder()
      .gpuClasses(gpuClassesList)
      .cpu(4L)
      .memory(8192L)
      .storageAmount(1000000000L)
      .countryCodes(countryCodesList)
      .build();

    GpuAvailability response = saladCloudSdk.organizationData.getGpuAvailability("acme-corp", gpuAvailabilityPrototype);

    System.out.println(response);
  }
}

```
