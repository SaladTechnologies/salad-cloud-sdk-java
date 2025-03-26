# ContainerLoggingConfigurationHttp2

Configuration for sending container logs to an HTTP endpoint. Defines how logs are formatted, compressed, and transmitted.

**Properties**

| Name        | Type                                          | Required | Description                                                    |
| :---------- | :-------------------------------------------- | :------- | :------------------------------------------------------------- |
| host        | String                                        | ✅       | The hostname or IP address of the HTTP logging endpoint        |
| port        | Long                                          | ✅       | The port number of the HTTP logging endpoint (1-65535)         |
| format      | ContainerHttpLoggingConfigurationFormat2      | ✅       | The format in which logs will be delivered                     |
| compression | ContainerHttpLoggingConfigurationCompression2 | ✅       | The compression algorithm to apply to logs before transmission |
| user        | String                                        | ❌       | Optional username for HTTP authentication                      |
| password    | String                                        | ❌       | Optional password for HTTP authentication                      |
| path        | String                                        | ❌       | Optional URL path for the HTTP endpoint                        |
| headers     | List\<ContainerLoggingHttpHeader\>            | ❌       | Optional HTTP headers to include in log transmission requests  |
