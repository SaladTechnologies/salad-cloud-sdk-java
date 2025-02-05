```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointsList;
import com.salad.cloud.sdk.models.ListInferenceEndpointsParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ListInferenceEndpointsParameters requestParameters = ListInferenceEndpointsParameters
      .builder()
      .page(1536623748L)
      .pageSize(41L)
      .build();

    InferenceEndpointsList response = saladCloudSdk.inferenceEndpoints.listInferenceEndpoints(
      "r98kinnaq6opnq-td84vb3q9zv3k2ki3jzct2pf06rygg23yz",
      requestParameters
    );

    System.out.println(response);
  }
}

```
