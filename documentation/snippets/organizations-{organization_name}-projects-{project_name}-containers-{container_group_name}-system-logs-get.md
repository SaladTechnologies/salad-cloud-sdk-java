```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.SystemLogList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    SystemLogList response = saladCloudSdk.systemLogs.getSystemLogs(
      "fmcz5cnnkfiyt3k5ke3wy-5gl1809s8sotrp88klv3q4l4ni7uszkt0ht2",
      "jpum7p7dqeb0o9xu",
      "nlzoet3pfl3xit2pe40saanre16q8ug0u13rmnwb7eyumc1"
    );

    System.out.println(response);
  }
}

```
