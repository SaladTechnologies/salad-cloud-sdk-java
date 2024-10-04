```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstance;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstance response = saladCloudSdk.containerGroupsService.getContainerGroupInstance(
      "a09xnu6-fkv3",
      "ca4ydy-pi16e4ddle58fi8u9w2qgnsgj7cn",
      "b4p90a72aagy0fz",
      "container_group_instance_id"
    );

    System.out.println(response);
  }
}

```
