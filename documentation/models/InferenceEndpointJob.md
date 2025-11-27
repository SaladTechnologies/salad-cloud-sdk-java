# InferenceEndpointJob

Represents a inference endpoint job

**Properties**

| Name                  | Type                                                            | Required | Description                                    |
| :-------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------------------- |
| id                    | String                                                          | ✅       | The inference endpoint job identifier.         |
| inferenceEndpointName | String                                                          | ✅       | The inference endpoint name.                   |
| organizationName      | String                                                          | ✅       | The organization name.                         |
| input                 | Object                                                          | ✅       | The job input. May be any valid JSON.          |
| status                | [Status](Status.md)                                             | ✅       | The current status.                            |
| events                | List<[InferenceEndpointJobEvent](InferenceEndpointJobEvent.md)> | ✅       | The list of events.                            |
| createTime            | String                                                          | ✅       | The time the job was created.                  |
| updateTime            | String                                                          | ✅       | The time the job was last updated.             |
| metadata              | Object                                                          | ❌       | The job metadata. May be any valid JSON.       |
| webhook               | String                                                          | ❌       | The webhook URL called when the job completes. |
| webhookUrl            | String                                                          | ❌       | The webhook URL called when the job completes. |
| output                | Object                                                          | ❌       | The job output. May be any valid JSON.         |
