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

    saladCloudSdk.containerGroupsService.recreateContainerGroupInstance(
      "m-gfjsmt",
      "qljdg4",
      "nzzyoj4pl2kuh4c67m3ae7qwlwipkdye-ad90-cq0up7kyr6",
      "container_group_instance_id"
    );
  }
}

```
