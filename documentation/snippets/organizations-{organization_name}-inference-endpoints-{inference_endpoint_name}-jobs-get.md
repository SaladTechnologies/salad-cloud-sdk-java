```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJobCollection;
import com.salad.cloud.sdk.models.ListInferenceEndpointJobsParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ListInferenceEndpointJobsParameters requestParameters = ListInferenceEndpointJobsParameters
      .builder()
      .page(1L)
      .pageSize(1L)
      .build();

    InferenceEndpointJobCollection response = saladCloudSdk.inferenceEndpoints.listInferenceEndpointJobs(
      "acme-corp",
      "transcribe",
      requestParameters
    );

    System.out.println(response);
  }
}

```
