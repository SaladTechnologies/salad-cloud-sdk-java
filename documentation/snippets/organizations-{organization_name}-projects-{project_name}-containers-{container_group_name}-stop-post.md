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
      "jpqhlkkgd",
      "a9h5upyur493wxwbxrj4xt9wfx07sgyz1fs97sfhtue78-54vd",
      "jp2qrcnt-8a3"
    );
  }
}

```
