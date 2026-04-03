# InferenceEndpointJob

Represents a inference endpoint job

**Properties**

| Name                  | Type                                                            | Required | Description                                    |
| :-------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------------------- |
| createTime            | String                                                          | ✅       | The time the job was created.                  |
| events                | List<[InferenceEndpointJobEvent](InferenceEndpointJobEvent.md)> | ✅       | The list of events.                            |
| id                    | String                                                          | ✅       | The inference endpoint job identifier.         |
| inferenceEndpointName | String                                                          | ✅       | The inference endpoint name.                   |
| input                 | Object                                                          | ✅       | The job input. May be any valid JSON.          |
| organizationName      | String                                                          | ✅       | The organization name.                         |
| status                | [Status](Status.md)                                             | ✅       | The current status.                            |
| updateTime            | String                                                          | ✅       | The time the job was last updated.             |
| metadata              | Object                                                          | ❌       | The job metadata. May be any valid JSON.       |
| output                | Object                                                          | ❌       | The job output. May be any valid JSON.         |
| webhook               | String                                                          | ❌       | The webhook URL called when the job completes. |
| webhookUrl            | String                                                          | ❌       | The webhook URL called when the job completes. |
