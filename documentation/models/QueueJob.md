# QueueJob

Represents a queue job

**Properties**

| Name       | Type                | Required | Description                            |
| :--------- | :------------------ | :------- | :------------------------------------- |
| id         | String              | ✅       |                                        |
| input      | Object              | ✅       | The job input. May be any valid JSON.  |
| status     | QueueJobStatus      | ✅       |                                        |
| events     | List<QueueJobEvent> | ✅       |                                        |
| createTime | String              | ✅       |                                        |
| updateTime | String              | ✅       |                                        |
| metadata   | Object              | ❌       |                                        |
| webhook    | String              | ❌       |                                        |
| output     | Object              | ❌       | The job output. May be any valid JSON. |
