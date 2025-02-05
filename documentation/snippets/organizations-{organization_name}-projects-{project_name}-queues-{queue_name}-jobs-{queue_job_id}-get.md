```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.QueueJob;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    QueueJob response = saladCloudSdk.queues.getQueueJob(
      "hrf4burmjglxm0qfqui7u2clb2gfk12ij-g2i1z7we77-hpgwjdxcrr6-3c9",
      "dv3zyz-95e2zp7wjr",
      "zkrdg5h3eeasigc",
      "queue_job_id"
    );

    System.out.println(response);
  }
}

```
