```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateQueueJob;
import com.salad.cloud.sdk.models.QueueJob;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    CreateQueueJob createQueueJob = CreateQueueJob
      .builder()
      .input(new Object())
      .metadata(new Object())
      .webhook("webhook")
      .build();

    QueueJob response = saladCloudSdk.queues.createQueueJob(
      "yl-v1qf-186n2145dgb2tg1emlkmk",
      "ufo7nbyl9hodgr47mbi5x5lh",
      "g-5jd",
      createQueueJob
    );

    System.out.println(response);
  }
}

```
