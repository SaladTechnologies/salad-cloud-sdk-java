```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateQueue;
import com.salad.cloud.sdk.models.Queue;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    CreateQueue createQueue = CreateQueue
      .builder()
      .name("ho4d79h7bg0vpngqc8hz5pxjwi")
      .displayName("IWPKHVWPTc")
      .description("aliqua id nostrud")
      .build();

    Queue response = saladCloudSdk.queuesService.createQueue(
      "xtp82b9jzwqov1insghigvfq0donadhrrdqx-2redu46g7e",
      "xk27gbnpmwk5xor49bk4ujk7",
      createQueue
    );

    System.out.println(response);
  }
}

```
