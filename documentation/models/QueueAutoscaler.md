# QueueAutoscaler

Represents the autoscaling rules for a queue

**Properties**

| Name                  | Type | Required | Description |
| :-------------------- | :--- | :------- | :---------- |
| minReplicas           | Long | ✅       |             |
| maxReplicas           | Long | ✅       |             |
| desiredQueueLength    | Long | ✅       |             |
| pollingPeriod         | Long | ❌       |             |
| maxUpscalePerMinute   | Long | ❌       |             |
| maxDownscalePerMinute | Long | ❌       |             |
