```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.QueueList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    QueueList response = saladCloudSdk.queuesService.listQueues(
      "xtp82b9jzwqov1insghigvfq0donadhrrdqx-2redu46g7e",
      "xk27gbnpmwk5xor49bk4ujk7"
    );

    System.out.println(response);
  }
}

```
