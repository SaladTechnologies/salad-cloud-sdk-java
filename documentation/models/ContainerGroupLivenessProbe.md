# ContainerGroupLivenessProbe

Defines a liveness probe for container groups that determines when to restart a container if it becomes unhealthy

**Properties**

| Name                | Type                                 | Required | Description                                                                                                                       |
| :------------------ | :----------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------- |
| failureThreshold    | Long                                 | ✅       | Number of consecutive failures required to consider the probe as failed                                                           |
| initialDelaySeconds | Long                                 | ✅       | Number of seconds to wait after container start before initiating liveness probes                                                 |
| periodSeconds       | Long                                 | ✅       | Frequency in seconds at which the probe should be executed                                                                        |
| successThreshold    | Long                                 | ✅       | Number of consecutive successes required to consider the probe successful                                                         |
| timeoutSeconds      | Long                                 | ✅       | Number of seconds after which the probe times out if no response is received                                                      |
| exec                | ContainerGroupProbeExec              | ❌       | Defines the exec action for a probe in a container group. This is used to execute a command inside a container for health checks. |
| grpc                | ContainerGroupGRpcProbe              | ❌       | Configuration for gRPC-based health probes in container groups, used to determine container health status.                        |
| http                | ContainerGroupHttpProbeConfiguration | ❌       | Defines HTTP probe configuration for container health checks within a container group.                                            |
| tcp                 | ContainerGroupTcpProbe               | ❌       | Configuration for a TCP probe used to check container health via network connectivity.                                            |
