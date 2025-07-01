# LogEntryQuery

Represents a query for logs

**Properties**

| Name      | Type                   | Required | Description                                                                                                                                                 |
| :-------- | :--------------------- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| endTime   | String                 | ✅       | The end time of the time range                                                                                                                              |
| query     | String                 | ✅       | The query string for filtering logs                                                                                                                         |
| startTime | String                 | ✅       | The start time of the time range                                                                                                                            |
| pageSize  | Long                   | ❌       | The maximum number of items per page.                                                                                                                       |
| sortOrder | LogEntryQuerySortOrder | ❌       | The sort order of the log entries. `asc` will sort the log entries in chronological order. `desc` will sort the log entries in reverse chronological order. |
