```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.queuesService.deleteQueueJob(
      "j-8sae7t0u7o0emyztq64o8ut710qtepjztx34mk6lruecseiyq06ab3ok5xr",
      "eokxas9m7y892q4m5rifzmevenpg1vot8xgbal184sloim-c7555huym18dia9d",
      "zbvvpn2qgtohp",
      "queue_job_id"
    );
  }
}

```
