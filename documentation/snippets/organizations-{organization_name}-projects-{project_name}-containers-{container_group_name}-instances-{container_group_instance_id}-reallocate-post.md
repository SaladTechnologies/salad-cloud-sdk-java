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

    saladCloudSdk.containerGroupsService.reallocateContainerGroupInstance(
      "xk27gbnpmwk5xor49bk4ujk7",
      "cy1l6xj-5vzihwp4ho850l3faynnuq71ru6y",
      "mgza-e8llajq25o36x8b-38phh",
      "container_group_instance_id"
    );
  }
}

```
