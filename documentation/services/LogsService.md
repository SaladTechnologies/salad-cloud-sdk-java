# LogsService

A list of all methods in the `LogsService` service. Click on the method name to view detailed information about that method.

| Methods                             | Description                                                                                                               |
| :---------------------------------- | :------------------------------------------------------------------------------------------------------------------------ |
| [queryLogEntries](#querylogentries) | Retrieve a collection of _log entries_ for the _organization_ identified by `{organization_name}` matching the log query. |

## queryLogEntries

Retrieve a collection of _log entries_ for the _organization_ identified by `{organization_name}` matching the log query.

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/log-entries`

**Parameters**

| Name             | Type                                        | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :------------------------------------------ | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String                                      | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| logEntryQuery    | [LogEntryQuery](../models/LogEntryQuery.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`LogEntryCollection`

**Example Usage Code Snippet**

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
