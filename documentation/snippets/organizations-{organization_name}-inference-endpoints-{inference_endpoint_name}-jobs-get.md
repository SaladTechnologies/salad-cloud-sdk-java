```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.GetInferenceEndpointJobsParameters;
import com.salad.cloud.sdk.models.InferenceEndpointJobList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    GetInferenceEndpointJobsParameters requestParameters = GetInferenceEndpointJobsParameters
      .builder()
      .page(355955712L)
      .pageSize(39L)
      .build();

    InferenceEndpointJobList response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpointJobs(
      "yg0u13rmnwb7eyumc25lm4prwopvwr-1961f",
      "consectetur occaecat",
      requestParameters
    );

    System.out.println(response);
  }
}

```
