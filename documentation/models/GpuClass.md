# GpuClass

Represents a GPU Class

**Properties**

| Name         | Type                | Required | Description                                          |
| :----------- | :------------------ | :------- | :--------------------------------------------------- |
| id           | String              | ✅       | The unique identifier                                |
| name         | String              | ✅       | The GPU class name                                   |
| prices       | List<GpuClassPrice> | ✅       | The list of prices for each container group priority |
| isHighDemand | Boolean             | ❌       | Whether the GPU class is in high demand              |
