# WorkloadError

Represents a workload error

**Properties**

| Name        | Type   | Required | Description                                                                             |
| :---------- | :----- | :------- | :-------------------------------------------------------------------------------------- |
| allocatedAt | String | ✅       | The timestamp when the workload was initially allocated to a machine                    |
| detail      | String | ✅       | A detailed error message describing the nature and cause of the workload failure        |
| failedAt    | String | ✅       | The timestamp when the workload failure was detected or reported                        |
| instanceId  | String | ✅       | The container group instance identifier.                                                |
| machineId   | String | ✅       | The container group machine identifier.                                                 |
| version     | Long   | ✅       | The schema version number for this error record, used for tracking error format changes |
| startedAt   | String | ❌       | The timestamp when the workload started execution, or null if it failed before starting |
