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

    InferenceEndpoint response = saladCloudSdk.inferenceEndpointsService.getInferenceEndpoint(
      "uzp1dyfm2yp4-lxa27tl0fwms3fu3myo74a99jr6ouv4w8",
      "aute Ut reprehenderit occaecat sed"
    );

    System.out.println(response);
  }
}

```