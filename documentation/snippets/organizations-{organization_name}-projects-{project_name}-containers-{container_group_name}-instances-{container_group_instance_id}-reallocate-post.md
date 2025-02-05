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

    saladCloudSdk.containerGroups.reallocateContainerGroupInstance(
      "a7tl0fwms3fu3myo74a99jr6ouv4w914sp420zyiuo43jexn",
      "czq6rnxf04dqmccakh",
      "k9g3a72svbjzx0y-i4o1cvulgdrylaujk1yrzfoq1",
      "container_group_instance_id"
    );
  }
}

```
