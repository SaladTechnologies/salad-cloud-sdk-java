# QueueJob

Represents a queue job

**Properties**

| Name       | Type                                    | Required | Description                                      |
| :--------- | :-------------------------------------- | :------- | :----------------------------------------------- |
| createTime | String                                  | ✅       | The job creation time                            |
| events     | List<[QueueJobEvent](QueueJobEvent.md)> | ✅       | The job events                                   |
| id         | String                                  | ✅       | The job identifier                               |
| input      | Object                                  | ✅       | The job input. May be any valid JSON.            |
| status     | QueueJobStatus                          | ✅       | The job status                                   |
| updateTime | String                                  | ✅       | The job update time                              |
| metadata   | Object                                  | ❌       | Additional metadata for the job                  |
| output     | Object                                  | ❌       | The job output. May be any valid JSON.           |
| webhook    | String                                  | ❌       | The webhook URL to notify when the job completes |
