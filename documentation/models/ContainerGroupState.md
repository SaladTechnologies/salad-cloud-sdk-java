# ContainerGroupState

Represents a container group state

**Properties**

| Name                 | Type                              | Required | Description                                        |
| :------------------- | :-------------------------------- | :------- | :------------------------------------------------- |
| status               | ContainerGroupStatus              | ✅       |                                                    |
| startTime            | String                            | ✅       |                                                    |
| finishTime           | String                            | ✅       |                                                    |
| instanceStatusCounts | ContainerGroupInstanceStatusCount | ✅       | Represents a container group instance status count |
| description          | String                            | ❌       |                                                    |
