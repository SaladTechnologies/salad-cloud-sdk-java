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

    Queue response = saladCloudSdk.queues.getQueue(
      "xrt9bh26smkuf3v0nd2roppi64zikv73wys88ns82g85qcczec2y8bnwc4gs",
      "y6aeebojnkc8rl8-7pysy62j25cdn",
      "ujh0v34w5-21z63jxnxh38ckz48-k1ecu"
    );

    System.out.println(response);
  }
}

```
