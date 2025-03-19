# ContainerGroupGRpcProbe

Configuration for gRPC-based health probes in container groups, used to determine container health status.

**Properties**

| Name    | Type   | Required | Description                                                             |
| :------ | :----- | :------- | :---------------------------------------------------------------------- |
| port    | Long   | ✅       | The port number on which the gRPC health check service is exposed.      |
| service | String | ✅       | The name of the gRPC service that implements the health check protocol. |
