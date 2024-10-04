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
      .page(706148771L)
      .pageSize(45L)
      .build();

    QueueJobList response = saladCloudSdk.queuesService.listQueueJobs(
      "wcaz2jbu5pfmpygxffsf4bh4e6",
      "dzh9lv6afpamv8cx0x6",
      "s9f4ikmr0j6c3n18n4djttkqmgzb46dd5wogzrfe2pq12s2",
      requestParameters
    );

    System.out.println(response);
  }
}

```
