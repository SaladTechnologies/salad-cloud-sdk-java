# ContainerGroupLivenessProbe

Represents the container group liveness probe

**Properties**

| Name                | Type                    | Required | Description |
| :------------------ | :---------------------- | :------- | :---------- |
| initialDelaySeconds | Long                    | ✅       |             |
| periodSeconds       | Long                    | ✅       |             |
| timeoutSeconds      | Long                    | ✅       |             |
| successThreshold    | Long                    | ✅       |             |
| failureThreshold    | Long                    | ✅       |             |
| tcp                 | ContainerGroupProbeTcp  | ❌       |             |
| http                | ContainerGroupProbeHttp | ❌       |             |
| grpc                | ContainerGroupProbeGrpc | ❌       |             |
| exec                | ContainerGroupProbeExec | ❌       |             |
