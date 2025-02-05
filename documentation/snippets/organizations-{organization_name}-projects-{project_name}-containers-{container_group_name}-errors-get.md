```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.WorkloadErrorList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    WorkloadErrorList response = saladCloudSdk.workloadErrors.getWorkloadErrors(
      "x4djttkqmgzb46dd5wogzrfe1",
      "l12s3mq9cm-jv1bq27ohe5dpzbgr",
      "hgvpuhecson4k2eclxss450txd1j0ixuhfk-hdff3n3-hbtsigyh53bt0g4g"
    );

    System.out.println(response);
  }
}

```
