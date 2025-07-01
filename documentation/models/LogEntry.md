# LogEntry

**Properties**

| Name         | Type             | Required | Description                                |
| :----------- | :--------------- | :------- | :----------------------------------------- |
| receiveTime  | String           | ✅       | The time when the log entry was received   |
| resource     | LogEntryResource | ✅       | The resource associated with the log entry |
| severity     | LogEntrySeverity | ✅       | The severity level of the log entry        |
| time         | String           | ✅       | The timestamp of the log entry             |
| jsonLog      | Object           | ❌       | The log message in JSON format.            |
| parentSpanId | String           | ❌       | The parent span ID of the log entry        |
| spanId       | String           | ❌       | The span ID of the log entry               |
| textLog      | String           | ❌       | The log message in text format.            |
| traceId      | String           | ❌       | The trace ID of the log entry              |
