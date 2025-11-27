```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.Queue;
import com.salad.cloud.sdk.models.QueuePatch;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    QueuePatch queuePatch = QueuePatch.builder().displayName("5Ecnf").description("description").build();

    Queue response = saladCloudSdk.queues.updateQueue("acme-corp", "dev-env", "fifo-queue", queuePatch);

    System.out.println(response);
  }
}

```
