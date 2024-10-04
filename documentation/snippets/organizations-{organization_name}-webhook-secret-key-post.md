```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WebhookSecretKey;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    WebhookSecretKey response = saladCloudSdk.webhookSecretKeyService.updateWebhookSecretKey(
      "mouv4w914sp420zyiuo43jexocjzq6rnxf04dqmccakipx9g3a72svbj"
    );

    System.out.println(response);
  }
}

```
