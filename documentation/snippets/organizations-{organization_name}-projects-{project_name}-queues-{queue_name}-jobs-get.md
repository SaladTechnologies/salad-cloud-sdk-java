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
      .page(1675858596L)
      .pageSize(52L)
      .build();

    QueueJobList response = saladCloudSdk.queues.listQueueJobs("acme-corp", "dev-env", "fifo-queue", requestParameters);

    System.out.println(response);
  }
}

```
