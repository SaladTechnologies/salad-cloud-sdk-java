```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ListQueueJobsParameters;
import com.salad.cloud.sdk.models.QueueJobList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ListQueueJobsParameters requestParameters = ListQueueJobsParameters
      .builder()
      .page(1000778021L)
      .pageSize(88L)
      .build();

    QueueJobList response = saladCloudSdk.queues.listQueueJobs(
      "yl-v1qf-186n2145dgb2tg1emlkmk",
      "ufo7nbyl9hodgr47mbi5x5lh",
      "g-5jd",
      requestParameters
    );

    System.out.println(response);
  }
}

```
