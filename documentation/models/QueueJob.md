# QueueJob

Represents a queue job

**Properties**

| Name       | Type                  | Required | Description                                      |
| :--------- | :-------------------- | :------- | :----------------------------------------------- |
| id         | String                | ✅       | The job identifier                               |
| input      | Object                | ✅       | The job input. May be any valid JSON.            |
| status     | QueueJobStatus        | ✅       | The job status                                   |
| events     | List\<QueueJobEvent\> | ✅       | The job events                                   |
| createTime | String                | ✅       | The job creation time                            |
| updateTime | String                | ✅       | The job update time                              |
| metadata   | Object                | ❌       | Additional metadata for the job                  |
| webhook    | String                | ❌       | The webhook URL to notify when the job completes |
| output     | Object                | ❌       | The job output. May be any valid JSON.           |
