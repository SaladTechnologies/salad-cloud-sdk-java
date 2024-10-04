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

    QueueJob response = saladCloudSdk.queuesService.createQueueJob(
      "wcaz2jbu5pfmpygxffsf4bh4e6",
      "dzh9lv6afpamv8cx0x6",
      "s9f4ikmr0j6c3n18n4djttkqmgzb46dd5wogzrfe2pq12s2",
      createQueueJob
    );

    System.out.println(response);
  }
}

```
