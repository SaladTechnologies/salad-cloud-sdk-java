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

    saladCloudSdk.containerGroups.deleteContainerGroup(
      "mk0yct7b8bo1g8tvl9",
      "ax4qyju9jcnr3fw8e9al8o-4oreg5ocaz2jbu5pfmpygxffsf4bh4e6",
      "dzh9lv6afpamv8cx0x6"
    );
  }
}

```
