```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstancePatch;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstancePatch containerGroupInstancePatch = ContainerGroupInstancePatch
      .builder()
      .deletionCost(76724L)
      .build();

    ContainerGroupInstance response = saladCloudSdk.containerGroups.updateContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100",
      containerGroupInstancePatch
    );

    System.out.println(response);
  }
}

```
