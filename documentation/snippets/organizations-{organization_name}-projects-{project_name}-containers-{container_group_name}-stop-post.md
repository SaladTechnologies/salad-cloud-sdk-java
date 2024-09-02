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

    saladCloudSdk.containerGroupsService.stopContainerGroup(
      "c0o0gqev-mnkpy8af-s7rq68p2lenu8izbg09xnu6-fkv4dta4yd",
      "rpi16e4ddle58fi8u9w2qgnsgj7cnci4p90a72aagy0f001ws1rwna83a3asuz",
      "fd6ugn07m5xpcp89lefemdke05z4s9eg1d2caksvlhpzm"
    );
  }
}

```
