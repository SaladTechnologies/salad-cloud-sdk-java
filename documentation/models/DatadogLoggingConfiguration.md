# DatadogLoggingConfiguration

Configuration for forwarding container logs to Datadog monitoring service.

**Properties**

| Name   | Type                                  | Required | Description                                                                           |
| :----- | :------------------------------------ | :------- | :------------------------------------------------------------------------------------ |
| host   | String                                | ✅       | The Datadog intake server host URL where logs will be sent.                           |
| apiKey | String                                | ✅       | The Datadog API key used for authentication when sending logs.                        |
| tags   | List\<DatadogTagForContainerLogging\> | ✅       | Optional metadata tags to attach to logs for filtering and categorization in Datadog. |
