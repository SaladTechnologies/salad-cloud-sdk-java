# SystemLog

Represents a system log

**Properties**

| Name                  | Type   | Required | Description                                       |
| :-------------------- | :----- | :------- | :------------------------------------------------ |
| eventName             | String | ✅       | The name of the event                             |
| eventTime             | String | ✅       | The UTC date & time when the log item was created |
| resourceCpu           | Long   | ✅       | The number of CPUs                                |
| resourceGpuClass      | String | ✅       | The GPU class name                                |
| resourceMemory        | Long   | ✅       | The memory amount in MB                           |
| resourceStorageAmount | Long   | ✅       | The storage amount in bytes                       |
| version               | String | ✅       | The version instance ID                           |
| instanceId            | String | ❌       | The container group instance identifier.          |
| machineId             | String | ❌       | The container group machine identifier.           |
