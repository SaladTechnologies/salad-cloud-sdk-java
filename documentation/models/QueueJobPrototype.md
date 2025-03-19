# QueueJobPrototype

Represents a request to create a queue job

**Properties**

| Name     | Type   | Required | Description                                |
| :------- | :----- | :------- | :----------------------------------------- |
| input    | Object | ✅       | The job input. May be any valid JSON.      |
| metadata | Object | ❌       | Additional metadata for the job            |
| webhook  | String | ❌       | The webhook to call when the job completes |
