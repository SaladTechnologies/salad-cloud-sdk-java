# ContainerRegistryAuthentication

Authentication configuration for various container registry types, including AWS ECR, Docker Hub, GCP GAR, GCP GCR, and basic authentication.

**Properties**

| Name      | Type                                     | Required | Description                                                                 |
| :-------- | :--------------------------------------- | :------- | :-------------------------------------------------------------------------- |
| awsEcr    | ContainerRegistryAuthenticationAwsEcr    | ❌       | Authentication details for AWS Elastic Container Registry (ECR)             |
| basic     | ContainerRegistryAuthenticationBasic     | ❌       | Basic username and password authentication for generic container registries |
| dockerHub | ContainerRegistryAuthenticationDockerHub | ❌       | Authentication details for Docker Hub registry                              |
| gcpGar    | ContainerRegistryAuthenticationGcpGar    | ❌       | Authentication details for Google Artifact Registry (GAR)                   |
| gcpGcr    | ContainerRegistryAuthenticationGcpGcr    | ❌       | Authentication details for Google Container Registry (GCR)                  |
