```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.QueueList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    QueueList response = saladCloudSdk.queuesService.listQueues(
      "rtxaydgbmb5wprcvb9628akhug9lnd3c0",
      "p4bdb9jsi-f1xex70mdgjf5n-5ua-e28xyu9ujbls0vsz6xilo12xl52y9c177"
    );

    System.out.println(response);
  }
}

```
