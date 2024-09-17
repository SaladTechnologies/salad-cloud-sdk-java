# ContainerGroupInstance

Represents the details of a single container group instance

**Properties**

| Name       | Type    | Required | Description                                                                                                                                            |
| :--------- | :------ | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------- |
| instanceId | String  | ✅       | The unique instance ID                                                                                                                                 |
| machineId  | String  | ✅       | The machine ID                                                                                                                                         |
| state      | State   | ✅       | The state of the container group instance                                                                                                              |
| updateTime | String  | ✅       | The UTC date & time when the workload on this machine transitioned to the current state                                                                |
| version    | Long    | ✅       | The version of the running container group                                                                                                             |
| ready      | Boolean | ❌       | Specifies whether the container group instance is currently passing its readiness check. If no readiness probe is defined, is true once fully started. |
| started    | Boolean | ❌       | Specifies whether the container group instance passed its startup probe. Is always true when no startup probe is defined.                              |
