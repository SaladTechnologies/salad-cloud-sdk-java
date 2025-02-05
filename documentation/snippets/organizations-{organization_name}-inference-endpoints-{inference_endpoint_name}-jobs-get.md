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
      .page(1228703779L)
      .pageSize(80L)
      .build();

    InferenceEndpointJobList response = saladCloudSdk.inferenceEndpoints.getInferenceEndpointJobs(
      "pk05fdmxk23ipxt6vd6e",
      "inference_endpoint_name",
      requestParameters
    );

    System.out.println(response);
  }
}

```
