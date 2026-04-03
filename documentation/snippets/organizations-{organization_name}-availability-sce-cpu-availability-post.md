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
