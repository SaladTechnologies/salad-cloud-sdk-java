# ContainerGroup

Represents a container group

**Properties**

| Name            | Type                          | Required | Description                                                                                     |
| :-------------- | :---------------------------- | :------- | :---------------------------------------------------------------------------------------------- |
| id              | String                        | ✅       |                                                                                                 |
| name            | String                        | ✅       |                                                                                                 |
| displayName     | String                        | ✅       |                                                                                                 |
| container       | Container                     | ✅       | Represents a container                                                                          |
| autostartPolicy | Boolean                       | ✅       |                                                                                                 |
| restartPolicy   | ContainerRestartPolicy        | ✅       |                                                                                                 |
| replicas        | Long                          | ✅       |                                                                                                 |
| currentState    | ContainerGroupState           | ✅       | Represents a container group state                                                              |
| createTime      | String                        | ✅       |                                                                                                 |
| updateTime      | String                        | ✅       |                                                                                                 |
| pendingChange   | Boolean                       | ✅       |                                                                                                 |
| version         | Long                          | ✅       |                                                                                                 |
| countryCodes    | List<CountryCode>             | ❌       | List of countries nodes must be located in. Remove this field to permit nodes from any country. |
| networking      | ContainerGroupNetworking      | ❌       | Represents container group networking parameters                                                |
| livenessProbe   | ContainerGroupLivenessProbe   | ❌       | Represents the container group liveness probe                                                   |
| readinessProbe  | ContainerGroupReadinessProbe  | ❌       | Represents the container group readiness probe                                                  |
| startupProbe    | ContainerGroupStartupProbe    | ❌       | Represents the container group startup probe                                                    |
| queueConnection | ContainerGroupQueueConnection | ❌       | Represents container group queue connection                                                     |
