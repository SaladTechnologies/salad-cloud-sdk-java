# ContainerGroupNetworking

Represents container group networking parameters

**Properties**

| Name                  | Type                                 | Required | Description |
| :-------------------- | :----------------------------------- | :------- | :---------- |
| protocol              | ContainerNetworkingProtocol          | ✅       |             |
| port                  | Long                                 | ✅       |             |
| auth                  | Boolean                              | ✅       |             |
| dns                   | String                               | ✅       |             |
| loadBalancer          | ContainerGroupNetworkingLoadBalancer | ❌       |             |
| singleConnectionLimit | Boolean                              | ❌       |             |
| clientRequestTimeout  | Long                                 | ❌       |             |
| serverResponseTimeout | Long                                 | ❌       |             |
