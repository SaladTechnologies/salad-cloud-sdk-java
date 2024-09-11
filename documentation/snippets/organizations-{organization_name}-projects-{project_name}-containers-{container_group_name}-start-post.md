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

    saladCloudSdk.containerGroupsService.startContainerGroup(
      "zfx07sgyz1fs97sfhtue78-54vdogp2qrcnt-8a",
      "v7jhy3jn2rdf012fi7ouno3mk9",
      "a4d0ajj5ajjquzeg-z3kvqxtnoxnlzhjhjt-8naw"
    );
  }
}

```
