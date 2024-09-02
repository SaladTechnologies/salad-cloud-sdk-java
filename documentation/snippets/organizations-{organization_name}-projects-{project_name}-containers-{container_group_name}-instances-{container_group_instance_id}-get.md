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
      "b0up7kyr7vabeivb96iwcvlvvm1n",
      "ngljb",
      "xtp82b9jzwqov1insghigvfq0donadhrrdqx-2redu46g7e",
      "container_group_instance_id"
    );

    System.out.println(response);
  }
}

```
