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

    saladCloudSdk.inferenceEndpoints.deleteInferenceEndpointJob(
      "igqfe6b1d0c-0auqqph3bt-7bft4c1m95idut36tc-x7mo2nsh7uoln",
      "inference_endpoint_name",
      "inference_endpoint_job_id"
    );
  }
}

```
