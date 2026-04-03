# GpuClass

Represents a GPU Class

**Properties**

| Name         | Type                                    | Required | Description                                          |
| :----------- | :-------------------------------------- | :------- | :--------------------------------------------------- |
| id           | String                                  | ✅       | The unique identifier                                |
| name         | String                                  | ✅       | The GPU class name                                   |
| prices       | List<[GpuClassPrice](GpuClassPrice.md)> | ✅       | The list of prices for each container group priority |
| gpuClassType | GpuClassType                            | ❌       | The type of GPU class                                |
| gpuCount     | Long                                    | ❌       | The number of GPUs in the cluster                    |
| isHighDemand | Boolean                                 | ❌       | Whether the GPU class is in high demand              |
| maxRam       | Long                                    | ❌       | The maximum RAM amount in MB                         |
| maxStorage   | Long                                    | ❌       | The maximum storage amount in bytes                  |
| maxVcpu      | Long                                    | ❌       | The maximum vCPU count                               |
| minRam       | Long                                    | ❌       | The minimum RAM amount in MB                         |
| minStorage   | Long                                    | ❌       | The minimum storage amount in bytes                  |
| minVcpu      | Long                                    | ❌       | The minimum vCPU count                               |
