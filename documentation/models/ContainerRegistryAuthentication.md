# ContainerRegistryAuthentication

Authentication configuration for various container registry types, including AWS ECR, Docker Hub, GCP GAR, GCP GCR, and basic authentication.

**Properties**

| Name      | Type                                                                                    | Required | Description                                                                 |
| :-------- | :-------------------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------- |
| awsEcr    | [ContainerRegistryAuthenticationAwsEcr](ContainerRegistryAuthenticationAwsEcr.md)       | ❌       | Authentication details for AWS Elastic Container Registry (ECR)             |
| basic     | [ContainerRegistryAuthenticationBasic](ContainerRegistryAuthenticationBasic.md)         | ❌       | Basic username and password authentication for generic container registries |
| dockerHub | [ContainerRegistryAuthenticationDockerHub](ContainerRegistryAuthenticationDockerHub.md) | ❌       | Authentication details for Docker Hub registry                              |
| gcpGar    | [ContainerRegistryAuthenticationGcpGar](ContainerRegistryAuthenticationGcpGar.md)       | ❌       | Authentication details for Google Artifact Registry (GAR)                   |
| gcpGcr    | [ContainerRegistryAuthenticationGcpGcr](ContainerRegistryAuthenticationGcpGcr.md)       | ❌       | Authentication details for Google Container Registry (GCR)                  |
