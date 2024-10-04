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

    saladCloudSdk.containerGroupsService.startContainerGroup(
      "jfybnugpd6",
      "jngr",
      "vjne2vq5j0d2m4f21ex5ozb1-4j-you0d7uftlpfgcaqa-2oc58y844mz"
    );
  }
}

```
