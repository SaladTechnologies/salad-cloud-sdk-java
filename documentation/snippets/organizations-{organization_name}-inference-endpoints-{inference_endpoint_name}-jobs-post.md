```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.InferenceEndpointJob;
import com.salad.cloud.sdk.models.InferenceEndpointJobPrototype;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    InferenceEndpointJobPrototype inferenceEndpointJobPrototype = InferenceEndpointJobPrototype.builder()
      .input(new Object())
      .metadata(new Object())
      .webhookUrl("https://webhook.example.com/events")
      .build();

    InferenceEndpointJob response = saladCloudSdk.inferenceEndpoints.createInferenceEndpointJob(
      "acme-corp",
      "transcribe",
      inferenceEndpointJobPrototype
    );

    System.out.println(response);
  }
}

```
