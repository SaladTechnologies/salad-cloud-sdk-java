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
      .page(121822981L)
      .pageSize(37L)
      .build();

    InferenceEndpointsList response = saladCloudSdk.inferenceEndpointsService.listInferenceEndpoints(
      "wtxd1j0ixuhfk-hdff3n3-hbtsigyh53bt0g4gjh8mcz4",
      requestParameters
    );

    System.out.println(response);
  }
}

```
