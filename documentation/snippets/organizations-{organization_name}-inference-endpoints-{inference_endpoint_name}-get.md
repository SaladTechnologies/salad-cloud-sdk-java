```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpoint;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    InferenceEndpoint response = saladCloudSdk.inferenceEndpoints.getInferenceEndpoint(
      "cx2mv031v8afyh5y7ht26t-sfc4u7-dhjnxb2hbrz-ipttu1m2vc",
      "inference_endpoint_name"
    );

    System.out.println(response);
  }
}

```
