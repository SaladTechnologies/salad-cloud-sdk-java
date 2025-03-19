# CreateContainerGroupNetworking

Network configuration for container groups specifying connectivity parameters, including authentication, protocol, and timeout settings

**Properties**

| Name                  | Type                                    | Required | Description                                                                                                                                                       |
| :-------------------- | :-------------------------------------- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| auth                  | Boolean                                 | ✅       | Determines whether authentication is required for network connections to the container group                                                                      |
| port                  | Long                                    | ✅       | The container group networking port.                                                                                                                              |
| protocol              | ContainerNetworkingProtocol             | ✅       | Defines the communication protocol used for network traffic between containers or external systems. Currently supports HTTP protocol for web-based communication. |
| clientRequestTimeout  | Long                                    | ❌       | The container group networking client request timeout.                                                                                                            |
| loadBalancer          | TheContainerGroupNetworkingLoadBalancer | ❌       | The container group networking load balancer.                                                                                                                     |
| serverResponseTimeout | Long                                    | ❌       | The container group networking server response timeout.                                                                                                           |
| singleConnectionLimit | Boolean                                 | ❌       | The container group networking single connection limit flag.                                                                                                      |
