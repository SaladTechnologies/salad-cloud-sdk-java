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
