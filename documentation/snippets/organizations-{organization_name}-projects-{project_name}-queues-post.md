```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueuePrototype;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    QueuePrototype queuePrototype = QueuePrototype.builder()
      .name("name")
      .displayName("7k")
      .description("description")
      .build();

    Queue response = saladCloudSdk.queues.createQueue("acme-corp", "dev-env", queuePrototype);

    System.out.println(response);
  }
}

```
