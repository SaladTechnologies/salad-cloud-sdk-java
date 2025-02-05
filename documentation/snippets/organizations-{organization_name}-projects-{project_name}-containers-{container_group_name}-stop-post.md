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

    saladCloudSdk.containerGroups.stopContainerGroup(
      "fooidhvnhwad",
      "azuh19krhv62or5c-im9-8sae7tz",
      "oo0emyztq64o8ut710qtepjztx34mk6lruecseiyq06ab3ok5xsg-okxar"
    );
  }
}

```
