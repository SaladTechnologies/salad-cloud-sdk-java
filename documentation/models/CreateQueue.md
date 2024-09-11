# CreateQueue

Represents a request to create a new queue.

**Properties**

| Name        | Type     | Required | Description                                                                                  |
| :---------- | :------- | :------- | :------------------------------------------------------------------------------------------- |
| name        | `String` | ✅       | The queue name. This must be unique within the project.                                      |
| displayName | `String` | ❌       | The display name. This may be used as a more human-readable name.                            |
| description | `String` | ❌       | The description. This may be used as a space for notes or other information about the queue. |
