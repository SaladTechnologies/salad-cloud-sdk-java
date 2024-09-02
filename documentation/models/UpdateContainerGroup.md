# UpdateContainerGroup

Represents a request to update a container group

**Properties**

| Name           | Type                           | Required | Description                                                                                     |
| :------------- | :----------------------------- | :------- | :---------------------------------------------------------------------------------------------- |
| displayName    | String                         | ❌       |                                                                                                 |
| container      | UpdateContainer                | ❌       | Represents an update container object                                                           |
| replicas       | Long                           | ❌       |                                                                                                 |
| countryCodes   | List<CountryCode>              | ❌       | List of countries nodes must be located in. Remove this field to permit nodes from any country. |
| networking     | UpdateContainerGroupNetworking | ❌       | Represents update container group networking parameters                                         |
| livenessProbe  | ContainerGroupLivenessProbe    | ❌       | Represents the container group liveness probe                                                   |
| readinessProbe | ContainerGroupReadinessProbe   | ❌       | Represents the container group readiness probe                                                  |
| startupProbe   | ContainerGroupStartupProbe     | ❌       | Represents the container group startup probe                                                    |
