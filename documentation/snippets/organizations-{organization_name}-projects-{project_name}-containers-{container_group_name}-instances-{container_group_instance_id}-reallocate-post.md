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
      "sws1rwna83a3asu0izd6ugn07m5xpcp89lefemdke05z4s9d",
      "ed2caksvlhpzmfccbh2v7dcapp3enb9gd2f4k49vviu53s5",
      "xkwwnw",
      "container_group_instance_id"
    );
  }
}

```
