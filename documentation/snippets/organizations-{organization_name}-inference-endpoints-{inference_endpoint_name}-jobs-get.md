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
      .page(1653138765L)
      .pageSize(76L)
      .build();

    InferenceEndpointJobList response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpointJobs(
      "trzfoq1p77wk9jgwxjp56dzbnwtbgowklqt1wsbe00",
      "ut officia ut",
      requestParameters
    );

    System.out.println(response);
  }
}

```
