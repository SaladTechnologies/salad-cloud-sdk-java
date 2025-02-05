# QueueAutoscaler

Represents the autoscaling rules for a queue

**Properties**

| Name                  | Type | Required | Description                                                     |
| :-------------------- | :--- | :------- | :-------------------------------------------------------------- |
| minReplicas           | Long | ✅       | The minimum number of instances the container can scale down to |
| maxReplicas           | Long | ✅       | The maximum number of instances the container can scale up to   |
| desiredQueueLength    | Long | ✅       |                                                                 |
| pollingPeriod         | Long | ❌       | The period (in seconds) in which the queue checks the formula   |
| maxUpscalePerMinute   | Long | ❌       | The maximum number of instances that can be added per minute    |
| maxDownscalePerMinute | Long | ❌       | The maximum number of instances that can be removed per minute  |
