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

    WorkloadErrorList response = saladCloudSdk.workloadErrorsService.getWorkloadErrors(
      "x4hd7xmy53wgq8mpuy5k2wfbbzlhws5edt3sje",
      "hug6abtk-ewjq1594j27m6u1whmqikj9f18pd",
      "lq52i317o2r8pje-v4-ccp8q-329szw31h4fee236"
    );

    System.out.println(response);
  }
}

```
