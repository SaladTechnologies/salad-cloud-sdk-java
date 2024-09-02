# CreateContainer

Represents a container

**Properties**

| Name                   | Type                                  | Required | Description                                                                                      |
| :--------------------- | :------------------------------------ | :------- | :----------------------------------------------------------------------------------------------- |
| image                  | String                                | ✅       |                                                                                                  |
| resources              | ContainerResourceRequirements         | ✅       | Represents a container resource requirements                                                     |
| command                | List<String>                          | ❌       | Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image. |
| priority               | ContainerGroupPriority                | ❌       |                                                                                                  |
| environmentVariables   | Map<String, String>                   | ❌       |                                                                                                  |
| logging                | CreateContainerLogging                | ❌       |                                                                                                  |
| registryAuthentication | CreateContainerRegistryAuthentication | ❌       |                                                                                                  |
