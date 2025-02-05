# SystemLog

Represents a system log

**Properties**

| Name                  | Type   | Required | Description                                       |
| :-------------------- | :----- | :------- | :------------------------------------------------ |
| eventName             | String | ✅       | The name of the event                             |
| eventTime             | String | ✅       | The UTC date & time when the log item was created |
| version               | String | ✅       | The version instance ID                           |
| resourceCpu           | Long   | ✅       | The number of CPUs                                |
| resourceMemory        | Long   | ✅       | The memory amount in MB                           |
| resourceGpuClass      | String | ✅       | The GPU class name                                |
| resourceStorageAmount | Long   | ✅       | The storage amount in bytes                       |
| instanceId            | String | ❌       | The unique instance ID                            |
| machineId             | String | ❌       | The organization-specific machine ID              |
