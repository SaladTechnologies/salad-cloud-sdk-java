# InferenceEndpointJob

Represents a inference endpoint job

**Properties**

| Name                  | Type                              | Required | Description                                    |
| :-------------------- | :-------------------------------- | :------- | :--------------------------------------------- |
| id                    | String                            | ✅       | The unique identifier.                         |
| input                 | Object                            | ✅       | The job input. May be any valid JSON.          |
| inferenceEndpointName | String                            | ✅       | The inference endpoint name.                   |
| status                | InferenceEndpointJobStatus        | ✅       | The current status.                            |
| events                | List\<InferenceEndpointJobEvent\> | ✅       | The list of events.                            |
| organizationName      | String                            | ✅       | The organization name.                         |
| createTime            | String                            | ✅       | The time the job was created.                  |
| updateTime            | String                            | ✅       | The time the job was last updated.             |
| metadata              | Object                            | ❌       | The job metadata. May be any valid JSON.       |
| webhook               | String                            | ❌       | The webhook URL called when the job completes. |
| output                | Object                            | ❌       | The job output. May be any valid JSON.         |
