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

    saladCloudSdk.containerGroups.restartContainerGroupInstance(
      "ogx1pei8lousb7ikadj659qttkrqdm5b9xdq",
      "cmet9ioqxf-a3suyfz4tkhle7s9-vpaj7uvpjx9jbtvwzjwvj900",
      "bqh9-1g8glb2305o-txbnrdvt2jc9nvk5fkdf18q9zdv3",
      "container_group_instance_id"
    );
  }
}

```
