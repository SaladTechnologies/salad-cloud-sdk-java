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
      "kjhy3jn2rdf012fi7ouno3mk-ax4d0ajj5ajjquzeg-z3kvqxtnoxnlzhi",
      "ft-8nawc40o0gqev-m",
      "jpy8af-s7rq68p2lenu"
    );

    System.out.println(response);
  }
}

```
