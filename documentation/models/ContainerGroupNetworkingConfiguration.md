# ContainerGroupNetworkingConfiguration

Network configuration for container groups that defines connectivity, routing, and access control settings

**Properties**

| Name                  | Type                                                                                  | Required | Description                                                                                                                                                       |
| :-------------------- | :------------------------------------------------------------------------------------ | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| auth                  | Boolean                                                                               | ✅       | Whether authentication is required for network access to the container group                                                                                      |
| dns                   | String                                                                                | ✅       | Domain name or URL endpoint for the container group's network interface                                                                                           |
| loadBalancer          | [TheContainerGroupNetworkingLoadBalancer](TheContainerGroupNetworkingLoadBalancer.md) | ✅       | The container group networking load balancer.                                                                                                                     |
| port                  | Long                                                                                  | ✅       | The container group networking port.                                                                                                                              |
| protocol              | [ContainerNetworkingProtocol](ContainerNetworkingProtocol.md)                         | ✅       | Defines the communication protocol used for network traffic between containers or external systems. Currently supports HTTP protocol for web-based communication. |
| clientRequestTimeout  | Long                                                                                  | ❌       | The container group networking client request timeout.                                                                                                            |
| serverResponseTimeout | Long                                                                                  | ❌       | The container group networking server response timeout.                                                                                                           |
| singleConnectionLimit | Boolean                                                                               | ❌       | The container group networking single connection limit flag.                                                                                                      |
