# UpdateContainer

Represents an update container object

**Properties**

| Name                   | Type                                  | Required | Description                                                                                      |
| :--------------------- | :------------------------------------ | :------- | :----------------------------------------------------------------------------------------------- |
| image                  | String                                | ❌       |                                                                                                  |
| resources              | Resources                             | ❌       |                                                                                                  |
| command                | List<String>                          | ❌       | Pass a command (and optional arguments) to override the ENTRYPOINT and CMD of a container image. |
| priority               | ContainerGroupPriority                | ❌       |                                                                                                  |
| environmentVariables   | Map<String, String>                   | ❌       |                                                                                                  |
| logging                | UpdateContainerLogging                | ❌       |                                                                                                  |
| registryAuthentication | UpdateContainerRegistryAuthentication | ❌       |                                                                                                  |
