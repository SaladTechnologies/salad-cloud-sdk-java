```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstances;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstances response = saladCloudSdk.containerGroupsService.listContainerGroupInstances(
      "dcbh1",
      "pdcapp3enb9gd2f4k49vviu53s67ckwwnxsd-gfjsmuxcljdg4t1zzyoj",
      "vl2kuh4c67m3ae7qwlwipkdye-ad"
    );

    System.out.println(response);
  }
}

```
