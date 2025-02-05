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

    saladCloudSdk.containerGroups.recreateContainerGroupInstance(
      "l7wk9jgwxjp56dzbnwtbgowklqt1wsbe00osnj3370c21vihvroq1cuqjb",
      "g-0jo001xz6w2uhgmhtgvpqzhztmaqawqn92-rig0bznv-21cb7s",
      "ghp2ecbvldrihtmaa78lqy5q1wdpi7ayf187etvt65ezckogou9lhenou1q2jx",
      "container_group_instance_id"
    );
  }
}

```
