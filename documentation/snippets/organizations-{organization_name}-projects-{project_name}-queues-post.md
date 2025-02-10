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
      .name("name")
      .displayName("D4LmZEiVGB")
      .description("description")
      .build();

    Queue response = saladCloudSdk.queues.createQueue("acme-corp", "dev-env", createQueue);

    System.out.println(response);
  }
}

```
