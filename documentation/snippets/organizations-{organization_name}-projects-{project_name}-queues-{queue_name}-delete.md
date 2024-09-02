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

    saladCloudSdk.queuesService.deleteQueue(
      "g1bq27ohe5dpzbgsk8gvpuhecson4k2eclxss3",
      "wtxd1j0ixuhfk-hdff3n3-hbtsigyh53bt0g4gjh8mcz4",
      "bnkfiyt3k5ke3wy-5gl1809r"
    );
  }
}

```
