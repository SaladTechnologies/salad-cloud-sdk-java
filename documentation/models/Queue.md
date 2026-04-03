# Queue

Represents a queue.

**Properties**

| Name               | Type                                      | Required | Description                                                                                                                                                |
| :----------------- | :---------------------------------------- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------- |
| containerGroups    | List<[ContainerGroup](ContainerGroup.md)> | ✅       | The container groups that are part of this queue. Each container group represents a scalable set of identical containers running as a distributed service. |
| createTime         | String                                    | ✅       | The date and time the queue was created.                                                                                                                   |
| displayName        | String                                    | ✅       | The display name. This may be used as a more human-readable name.                                                                                          |
| id                 | String                                    | ✅       | The queue identifier. This is automatically generated and assigned when the queue is created.                                                              |
| name               | String                                    | ✅       | The queue name. This must be unique within the project.                                                                                                    |
| updateTime         | String                                    | ✅       | The date and time the queue was last updated.                                                                                                              |
| currentQueueLength | Long                                      | ❌       | The current length of the queue                                                                                                                            |
| description        | String                                    | ❌       | The description. This may be used as a space for notes or other information about the queue.                                                               |
