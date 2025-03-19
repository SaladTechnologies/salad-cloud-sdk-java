# ContainerGroupInstanceStatusCount

A summary of container group instances categorized by their current lifecycle status

**Properties**

| Name            | Type | Required | Description                                                                    |
| :-------------- | :--- | :------- | :----------------------------------------------------------------------------- |
| allocatingCount | Long | ✅       | The number of container instances that are currently being allocated resources |
| creatingCount   | Long | ✅       | The number of container instances that are in the process of being created     |
| runningCount    | Long | ✅       | The number of container instances that are currently running and operational   |
| stoppingCount   | Long | ✅       | The number of container instances that are in the process of stopping          |
