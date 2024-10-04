```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.Queue;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    Queue response = saladCloudSdk.queuesService.getQueue(
      "bb5wprcvb9628akhug9lnd2",
      "bw-4bdb9jsi-f1xex70mdgjf5n-5ua-e28xyu9ujbls0vsy",
      "wilo12xl52y9c178cmdya6ykpby-hunb0b6s7s2l"
    );

    System.out.println(response);
  }
}

```
