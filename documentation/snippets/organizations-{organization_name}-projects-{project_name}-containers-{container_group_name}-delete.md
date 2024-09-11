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

    saladCloudSdk.containerGroupsService.deleteContainerGroup(
      "gq7z7dvdopv2czgde1zrufxgiv5tp-kncd4gfzda9ik-lw",
      "xd-if9b1yvozs9trd4v0bll7qwslfehyhnfadnjp2w52gwrmz",
      "ojjj5b9hbe2fr6f5t7j1htjaws1zx3r"
    );
  }
}

```
