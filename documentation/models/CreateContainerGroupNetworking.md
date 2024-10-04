# CreateContainerGroupNetworking

Represents container group networking parameters

**Properties**

| Name                  | Type                                       | Required | Description |
| :-------------------- | :----------------------------------------- | :------- | :---------- |
| protocol              | ContainerNetworkingProtocol                | ✅       |             |
| port                  | Long                                       | ✅       |             |
| auth                  | Boolean                                    | ✅       |             |
| loadBalancer          | CreateContainerGroupNetworkingLoadBalancer | ❌       |             |
| singleConnectionLimit | Boolean                                    | ❌       |             |
| clientRequestTimeout  | Long                                       | ❌       |             |
| serverResponseTimeout | Long                                       | ❌       |             |
