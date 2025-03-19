# ContainerGroupsQuotas

Represents the organization quotas for container groups

**Properties**

| Name                                    | Type | Required | Description                                                              |
| :-------------------------------------- | :--- | :------- | :----------------------------------------------------------------------- |
| maxCreatedContainerGroups               | Long | ❌       | The maximum number of container groups that can be created               |
| containerInstanceQuota                  | Long | ❌       | The maximum number of replicas that can be created for a container group |
| containerReplicaQuota                   | Long | ❌       | The maximum number of replicas that can be created for a container group |
| containerReplicasUsed                   | Long | ❌       | The number of replicas that are currently in use                         |
| maxContainerGroupReallocationsPerMinute | Long | ❌       | The maximum number of container group reallocations per minute           |
| maxContainerGroupRecreatesPerMinute     | Long | ❌       | The maximum number of container group recreates per minute               |
| maxContainerGroupRestartsPerMinute      | Long | ❌       | The maximum number of container group restarts per minute                |
