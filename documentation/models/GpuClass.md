# GpuClass

Represents a GPU Class

**Properties**

| Name         | Type                  | Required | Description                                          |
| :----------- | :-------------------- | :------- | :--------------------------------------------------- |
| id           | String                | ✅       | The unique identifier                                |
| name         | String                | ✅       | The GPU class name                                   |
| prices       | List\<GpuClassPrice\> | ✅       | The list of prices for each container group priority |
| isHighDemand | Boolean               | ❌       | Whether the GPU class is in high demand              |
| gpuClassType | GpuClassType          | ❌       | The type of GPU class                                |
| minVcpu      | Long                  | ❌       | The minimum vCPU count                               |
| maxVcpu      | Long                  | ❌       | The maximum vCPU count                               |
| minRam       | Long                  | ❌       | The minimum RAM amount in GB                         |
| maxRam       | Long                  | ❌       | The maximum RAM amount in GB                         |
| minStorage   | Long                  | ❌       | The minimum storage amount in GB                     |
| maxStorage   | Long                  | ❌       | The maximum storage amount in GB                     |
