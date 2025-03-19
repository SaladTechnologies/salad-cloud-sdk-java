# ContainerGroupQueueConnection

Configuration for connecting a container group to a message queue system, enabling asynchronous communication between services.

**Properties**

| Name      | Type   | Required | Description                                                                                                                                                     |
| :-------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| path      | String | ✅       | The endpoint path for accessing the queue service, relative to the base URL of the queue server.                                                                |
| port      | Long   | ✅       | The network port number used to connect to the queue service. Must be a valid TCP/IP port between 1 and 65535.                                                  |
| queueName | String | ✅       | Unique identifier for the queue. Must start with a lowercase letter, can contain lowercase letters, numbers, and hyphens, and must end with a letter or number. |
