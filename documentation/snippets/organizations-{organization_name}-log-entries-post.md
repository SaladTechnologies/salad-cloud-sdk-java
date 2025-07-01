```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.LogEntryCollection;
import com.salad.cloud.sdk.models.LogEntryQuery;
import com.salad.cloud.sdk.models.LogEntryQuerySortOrder;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    LogEntryQuery logEntryQuery = LogEntryQuery.builder()
      .endTime("end_time")
      .pageSize(1L)
      .query("query")
      .sortOrder(LogEntryQuerySortOrder.DESC)
      .startTime("start_time")
      .build();

    LogEntryCollection response = saladCloudSdk.logs.queryLogEntries("acme-corp", logEntryQuery);

    System.out.println(response);
  }
}

```
