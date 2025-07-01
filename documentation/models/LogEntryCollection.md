# LogEntryCollection

Represents a page of organization logs

**Properties**

| Name             | Type             | Required | Description                                                                      |
| :--------------- | :--------------- | :------- | :------------------------------------------------------------------------------- |
| items            | List\<LogEntry\> | ✅       | A collection of log entries                                                      |
| organizationName | String           | ✅       | The organization name.                                                           |
| pageMaxTime      | String           | ✅       | The maximum time page boundary. This may be used when getting paginated results. |
| pageMinTime      | String           | ✅       | The minimum time page boundary. This may be used when getting paginated results. |
