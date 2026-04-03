# DatadogLoggingConfiguration

Configuration for forwarding container logs to Datadog monitoring service.

**Properties**

| Name   | Type                                                                    | Required | Description                                                                           |
| :----- | :---------------------------------------------------------------------- | :------- | :------------------------------------------------------------------------------------ |
| apiKey | String                                                                  | ✅       | The Datadog API key used for authentication when sending logs.                        |
| host   | String                                                                  | ✅       | The Datadog intake server host URL where logs will be sent.                           |
| tags   | List<[DatadogTagForContainerLogging](DatadogTagForContainerLogging.md)> | ✅       | Optional metadata tags to attach to logs for filtering and categorization in Datadog. |
