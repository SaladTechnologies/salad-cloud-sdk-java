# SystemLogsService

A list of all methods in the `SystemLogsService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description          |
| :------------------------------ | :------------------- |
| [getSystemLogs](#getsystemlogs) | Gets the System Logs |

## getSystemLogs

Gets the System Logs

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/system-logs`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Return Type**

`SystemLogList`

**Example Usage Code Snippet**

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

    SystemLogList response = saladCloudSdk.systemLogs.getSystemLogs("acme-corp", "dev-env", "j6");

    System.out.println(response);
  }
}

```
