```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateInferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJob;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    CreateInferenceEndpointJob createInferenceEndpointJob = CreateInferenceEndpointJob
      .builder()
      .input(new Object())
      .metadata(new Object())
      .webhookUrl("webhook_url")
      .build();

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpoints.createInferenceEndpointJob(
      "acme-corp",
      "transcribe",
      createInferenceEndpointJob
    );

    System.out.println(response);
  }
}

```
