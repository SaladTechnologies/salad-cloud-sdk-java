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

    ContainerGroupInstance response = saladCloudSdk.containerGroups.getContainerGroupInstance(
      "z-5ux2vsm",
      "mjjt13u7q3pryx",
      "qnnyigut20zp1dyfm2yp4-lw",
      "container_group_instance_id"
    );

    System.out.println(response);
  }
}

```
