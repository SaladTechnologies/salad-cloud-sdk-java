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

    WebhookSecretKey response = saladCloudSdk.webhookSecretKeyService.getWebhookSecretKey(
      "dyxdaqq1t3iwwpawdlk-78rt9bh26smkuf3v0nd2ropp"
    );

    System.out.println(response);
  }
}

```
