# Queue

Represents a queue.

**Properties**

| Name            | Type                 | Required | Description                                                                                   |
| :-------------- | :------------------- | :------- | :-------------------------------------------------------------------------------------------- |
| id              | String               | ✅       | The queue identifier. This is automatically generated and assigned when the queue is created. |
| name            | String               | ✅       | The queue name. This must be unique within the project.                                       |
| displayName     | String               | ✅       | The display name. This may be used as a more human-readable name.                             |
| containerGroups | List<ContainerGroup> | ✅       |                                                                                               |
| createTime      | String               | ✅       | The date and time the queue was created.                                                      |
| updateTime      | String               | ✅       | The date and time the queue was last updated.                                                 |
| description     | String               | ❌       | The description. This may be used as a space for notes or other information about the queue.  |
