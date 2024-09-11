# Container

Represents a container

**Properties**

| Name                 | Type                            | Required | Description                                  |
| :------------------- | :------------------------------ | :------- | :------------------------------------------- |
| image                | `String`                        | ✅       |                                              |
| resources            | `ContainerResourceRequirements` | ✅       | Represents a container resource requirements |
| command              | `List<String>`                  | ✅       |                                              |
| priority             | `ContainerGroupPriority`        | ❌       |                                              |
| size                 | `Long`                          | ❌       |                                              |
| hash                 | `String`                        | ❌       |                                              |
| environmentVariables | `Map<String, String>`           | ❌       |                                              |
| logging              | `ContainerLogging`              | ❌       |                                              |
