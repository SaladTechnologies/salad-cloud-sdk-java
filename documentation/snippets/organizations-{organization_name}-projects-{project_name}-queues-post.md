```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.CreateQueue;
import com.salad.cloud.sdk.models.Queue;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    CreateQueue createQueue = CreateQueue
      .builder()
      .name("name")
      .displayName("M a1HEy")
      .description("description")
      .build();

    Queue response = saladCloudSdk.queues.createQueue(
      "ymfonstzqzsopxf2dyjvm8sjxa281t2p7ne1m",
      "sxk12v91ajseb3fzyxdaq",
      createQueue
    );

    System.out.println(response);
  }
}

```
