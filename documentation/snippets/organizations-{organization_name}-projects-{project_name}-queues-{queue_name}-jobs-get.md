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
      .page(2110014563L)
      .pageSize(23L)
      .build();

    QueueJobList response = saladCloudSdk.queuesService.listQueueJobs(
      "jb7eyumc25lm4prwopvwr-1961g-m85nbqda3ufs",
      "sn780t45z2tw4xt1b86w0clx6vkq-3",
      "sx811v32aty9s-ghx1hm2nw1mhgooidhvnhwadaqzuh19krhv62or5c",
      requestParameters
    );

    System.out.println(response);
  }
}

```
