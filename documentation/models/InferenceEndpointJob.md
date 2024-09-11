# InferenceEndpointJob

Represents a inference endpoint job

**Properties**

| Name                  | Type                              | Required | Description                            |
| :-------------------- | :-------------------------------- | :------- | :------------------------------------- |
| id                    | `String`                          | ✅       |                                        |
| input                 | `Object`                          | ✅       | The job input. May be any valid JSON.  |
| inferenceEndpointName | `String`                          | ✅       | The inference endpoint name            |
| status                | `InferenceEndpointJobStatus`      | ✅       |                                        |
| events                | `List<InferenceEndpointJobEvent>` | ✅       |                                        |
| organizationName      | `String`                          | ✅       | The organization name                  |
| createTime            | `String`                          | ✅       |                                        |
| updateTime            | `String`                          | ✅       |                                        |
| metadata              | `Object`                          | ❌       |                                        |
| webhook               | `String`                          | ❌       |                                        |
| output                | `Object`                          | ❌       | The job output. May be any valid JSON. |
