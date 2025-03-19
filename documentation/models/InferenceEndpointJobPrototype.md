# InferenceEndpointJobPrototype

Represents a request to create a inference endpoint job

**Properties**

| Name       | Type   | Required | Description                                              |
| :--------- | :----- | :------- | :------------------------------------------------------- |
| input      | Object | ✅       | The job input. May be any valid JSON.                    |
| metadata   | Object | ❌       | The job metadata. May be any valid JSON.                 |
| webhook    | String | ❌       | The webhook URL to which the job results will be POSTed. |
| webhookUrl | String | ❌       | The webhook URL to which the job results will be POSTed. |
