# ContainerGroupsService

A list of all methods in the `ContainerGroupsService` service. Click on the method name to view detailed information about that method.

| Methods                                                               | Description                                                                                                                 |
| :-------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------- |
| [listContainerGroups](#listcontainergroups)                           | Gets the list of container groups                                                                                           |
| [createContainerGroup](#createcontainergroup)                         | Creates a new container group                                                                                               |
| [getContainerGroup](#getcontainergroup)                               | Gets a container group                                                                                                      |
| [updateContainerGroup](#updatecontainergroup)                         | Updates a container group                                                                                                   |
| [deleteContainerGroup](#deletecontainergroup)                         | Deletes a container group                                                                                                   |
| [startContainerGroup](#startcontainergroup)                           | Starts a container group                                                                                                    |
| [stopContainerGroup](#stopcontainergroup)                             | Stops a container group                                                                                                     |
| [listContainerGroupInstances](#listcontainergroupinstances)           | Gets the list of container group instances                                                                                  |
| [getContainerGroupInstance](#getcontainergroupinstance)               | Gets a container group instance                                                                                             |
| [reallocateContainerGroupInstance](#reallocatecontainergroupinstance) | Reallocates a container group instance to run on a different Salad Node                                                     |
| [recreateContainerGroupInstance](#recreatecontainergroupinstance)     | Stops a container, destroys it, and starts a new one without requiring the image to be downloaded again on a new Salad Node |
| [restartContainerGroupInstance](#restartcontainergroupinstance)       | Stops a container and restarts it on the same Salad Node                                                                    |

## listContainerGroups

Gets the list of container groups

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers`

**Parameters**

| Name             | Type   | Required | Description                                                                                                                                                                                                                                         |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName      | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |

**Return Type**

`ContainerGroupList`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupList;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupList response = saladCloudSdk.containerGroups.listContainerGroups("acme-corp", "dev-env");

    System.out.println(response);
  }
}

```

## createContainerGroup

Creates a new container group

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers`

**Parameters**

| Name                 | Type                                                      | Required | Description                                                                                                                                                                                                                                         |
| :------------------- | :-------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName     | String                                                    | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName          | String                                                    | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| createContainerGroup | [CreateContainerGroup](../models/CreateContainerGroup.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`ContainerGroup`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.models.ContainerGroupPriority;
import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.models.ContainerGroupProbeGrpc;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttp;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeaders2;
import com.salad.cloud.sdk.models.ContainerGroupProbeTcp;
import com.salad.cloud.sdk.models.ContainerGroupQueueConnection;
import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.models.ContainerNetworkingProtocol;
import com.salad.cloud.sdk.models.ContainerProbeHttpScheme;
import com.salad.cloud.sdk.models.ContainerResourceRequirements;
import com.salad.cloud.sdk.models.ContainerRestartPolicy;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.CreateContainer;
import com.salad.cloud.sdk.models.CreateContainerGroup;
import com.salad.cloud.sdk.models.CreateContainerGroupNetworking;
import com.salad.cloud.sdk.models.CreateContainerGroupNetworkingLoadBalancer;
import com.salad.cloud.sdk.models.CreateContainerLogging;
import com.salad.cloud.sdk.models.CreateContainerRegistryAuthentication;
import com.salad.cloud.sdk.models.DatadogTags2;
import com.salad.cloud.sdk.models.HttpCompression2;
import com.salad.cloud.sdk.models.HttpFormat2;
import com.salad.cloud.sdk.models.HttpHeaders3;
import com.salad.cloud.sdk.models.LoggingAxiom2;
import com.salad.cloud.sdk.models.LoggingDatadog2;
import com.salad.cloud.sdk.models.LoggingHttp2;
import com.salad.cloud.sdk.models.LoggingNewRelic2;
import com.salad.cloud.sdk.models.LoggingSplunk2;
import com.salad.cloud.sdk.models.LoggingTcp2;
import com.salad.cloud.sdk.models.QueueAutoscaler;
import com.salad.cloud.sdk.models.RegistryAuthenticationAwsEcr1;
import com.salad.cloud.sdk.models.RegistryAuthenticationBasic1;
import com.salad.cloud.sdk.models.RegistryAuthenticationDockerHub1;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGar1;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGcr1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<String> gpuClasses = Arrays.asList("gpu_classes");

    ContainerResourceRequirements containerResourceRequirements = ContainerResourceRequirements
      .builder()
      .cpu(3L)
      .memory(16094L)
      .gpuClasses(gpuClasses)
      .storageAmount(50473301867L)
      .build();

    List<String> command = Arrays.asList("command");

    LoggingAxiom2 loggingAxiom2 = LoggingAxiom2.builder().host("host").apiToken("api_token").dataset("dataset").build();

    DatadogTags2 datadogTags2 = DatadogTags2.builder().name("name").value("value").build();

    List<DatadogTags2> tags = Arrays.asList(datadogTags2);

    LoggingDatadog2 loggingDatadog2 = LoggingDatadog2.builder().host("host").apiKey("api_key").tags(tags).build();

    LoggingNewRelic2 loggingNewRelic2 = LoggingNewRelic2.builder().host("host").ingestionKey("ingestion_key").build();

    LoggingSplunk2 loggingSplunk2 = LoggingSplunk2.builder().host("host").token("token").build();

    LoggingTcp2 loggingTcp2 = LoggingTcp2.builder().host("host").port(52754L).build();

    HttpHeaders3 httpHeaders3 = HttpHeaders3.builder().name("name").value("value").build();

    List<HttpHeaders3> headers = Arrays.asList(httpHeaders3);

    LoggingHttp2 loggingHttp2 = LoggingHttp2
      .builder()
      .host("host")
      .port(58619L)
      .user("user")
      .password("password")
      .path("path")
      .format(HttpFormat2.JSON)
      .headers(headers)
      .compression(HttpCompression2.NONE)
      .build();

    CreateContainerLogging createContainerLogging = CreateContainerLogging
      .builder()
      .axiom(loggingAxiom2)
      .datadog(loggingDatadog2)
      .newRelic(loggingNewRelic2)
      .splunk(loggingSplunk2)
      .tcp(loggingTcp2)
      .http(loggingHttp2)
      .build();

    RegistryAuthenticationBasic1 registryAuthenticationBasic1 = RegistryAuthenticationBasic1
      .builder()
      .username("username")
      .password("password")
      .build();

    RegistryAuthenticationGcpGcr1 registryAuthenticationGcpGcr1 = RegistryAuthenticationGcpGcr1
      .builder()
      .serviceKey("service_key")
      .build();

    RegistryAuthenticationAwsEcr1 registryAuthenticationAwsEcr1 = RegistryAuthenticationAwsEcr1
      .builder()
      .accessKeyId("access_key_id")
      .secretAccessKey("secret_access_key")
      .build();

    RegistryAuthenticationDockerHub1 registryAuthenticationDockerHub1 = RegistryAuthenticationDockerHub1
      .builder()
      .username("username")
      .personalAccessToken("personal_access_token")
      .build();

    RegistryAuthenticationGcpGar1 registryAuthenticationGcpGar1 = RegistryAuthenticationGcpGar1
      .builder()
      .serviceKey("service_key")
      .build();

    CreateContainerRegistryAuthentication createContainerRegistryAuthentication = CreateContainerRegistryAuthentication
      .builder()
      .basic(registryAuthenticationBasic1)
      .gcpGcr(registryAuthenticationGcpGcr1)
      .awsEcr(registryAuthenticationAwsEcr1)
      .dockerHub(registryAuthenticationDockerHub1)
      .gcpGar(registryAuthenticationGcpGar1)
      .build();

    CreateContainer createContainer = CreateContainer
      .builder()
      .image("image")
      .resources(containerResourceRequirements)
      .command(command)
      .priority(ContainerGroupPriority.HIGH)
      .environmentVariables(new HashMap())
      .logging(createContainerLogging)
      .registryAuthentication(createContainerRegistryAuthentication)
      .build();

    List<CountryCode> countryCodes = Arrays.asList(CountryCode.AF);

    CreateContainerGroupNetworking createContainerGroupNetworking = CreateContainerGroupNetworking
      .builder()
      .protocol(ContainerNetworkingProtocol.HTTP)
      .port(64929L)
      .auth(true)
      .loadBalancer(CreateContainerGroupNetworkingLoadBalancer.ROUND_ROBIN)
      .singleConnectionLimit(true)
      .clientRequestTimeout(100000L)
      .serverResponseTimeout(100000L)
      .build();

    ContainerGroupProbeTcp containerGroupProbeTcp = ContainerGroupProbeTcp.builder().port(9366L).build();

    ContainerGroupProbeHttpHeaders2 containerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeaders2> headers = Arrays.asList(containerGroupProbeHttpHeaders2);

    ContainerGroupProbeHttp containerGroupProbeHttp = ContainerGroupProbeHttp
      .builder()
      .path("path")
      .port(398L)
      .scheme(ContainerProbeHttpScheme.HTTP)
      .headers(headers)
      .build();

    ContainerGroupProbeGrpc containerGroupProbeGrpc = ContainerGroupProbeGrpc
      .builder()
      .service("service")
      .port(23866L)
      .build();

    List<String> command = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(command).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(1L)
      .periodSeconds(10L)
      .timeoutSeconds(30L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(8L)
      .periodSeconds(1L)
      .timeoutSeconds(1L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(2L)
      .periodSeconds(3L)
      .timeoutSeconds(10L)
      .successThreshold(2L)
      .failureThreshold(1200L)
      .build();

    ContainerGroupQueueConnection containerGroupQueueConnection = ContainerGroupQueueConnection
      .builder()
      .path("path")
      .port(34806L)
      .queueName("r3qna2yfhck403bsaqbf6nweyawtm7q4ohr")
      .build();

    QueueAutoscaler queueAutoscaler = QueueAutoscaler
      .builder()
      .minReplicas(88L)
      .maxReplicas(197L)
      .desiredQueueLength(57L)
      .pollingPeriod(1449L)
      .maxUpscalePerMinute(85L)
      .maxDownscalePerMinute(33L)
      .build();

    CreateContainerGroup createContainerGroup = CreateContainerGroup
      .builder()
      .name("name")
      .displayName("ny")
      .container(createContainer)
      .autostartPolicy(true)
      .restartPolicy(ContainerRestartPolicy.ALWAYS)
      .replicas(47L)
      .countryCodes(countryCodes)
      .networking(createContainerGroupNetworking)
      .livenessProbe(containerGroupLivenessProbe)
      .readinessProbe(containerGroupReadinessProbe)
      .startupProbe(containerGroupStartupProbe)
      .queueConnection(containerGroupQueueConnection)
      .queueAutoscaler(queueAutoscaler)
      .build();

    ContainerGroup response = saladCloudSdk.containerGroups.createContainerGroup(
      "acme-corp",
      "dev-env",
      createContainerGroup
    );

    System.out.println(response);
  }
}

```

## getContainerGroup

Gets a container group

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Return Type**

`ContainerGroup`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroup;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroup response = saladCloudSdk.containerGroups.getContainerGroup("acme-corp", "dev-env", "n6eqezp9");

    System.out.println(response);
  }
}

```

## updateContainerGroup

Updates a container group

- HTTP Method: `PATCH`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}`

**Parameters**

| Name                 | Type                                                      | Required | Description                                                                                                                                                                                                                                         |
| :------------------- | :-------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName     | String                                                    | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName          | String                                                    | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName   | String                                                    | ✅       | The unique container group name                                                                                                                                                                                                                     |
| updateContainerGroup | [UpdateContainerGroup](../models/UpdateContainerGroup.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`ContainerGroup`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.models.ContainerGroupPriority;
import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.models.ContainerGroupProbeGrpc;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttp;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeaders2;
import com.salad.cloud.sdk.models.ContainerGroupProbeTcp;
import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.models.ContainerProbeHttpScheme;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.DatadogTags3;
import com.salad.cloud.sdk.models.HttpCompression3;
import com.salad.cloud.sdk.models.HttpFormat3;
import com.salad.cloud.sdk.models.HttpHeaders4;
import com.salad.cloud.sdk.models.LoggingAxiom3;
import com.salad.cloud.sdk.models.LoggingDatadog3;
import com.salad.cloud.sdk.models.LoggingHttp3;
import com.salad.cloud.sdk.models.LoggingNewRelic3;
import com.salad.cloud.sdk.models.LoggingSplunk3;
import com.salad.cloud.sdk.models.LoggingTcp3;
import com.salad.cloud.sdk.models.QueueAutoscaler;
import com.salad.cloud.sdk.models.RegistryAuthenticationAwsEcr2;
import com.salad.cloud.sdk.models.RegistryAuthenticationBasic2;
import com.salad.cloud.sdk.models.RegistryAuthenticationDockerHub2;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGar2;
import com.salad.cloud.sdk.models.RegistryAuthenticationGcpGcr2;
import com.salad.cloud.sdk.models.Resources;
import com.salad.cloud.sdk.models.UpdateContainer;
import com.salad.cloud.sdk.models.UpdateContainerGroup;
import com.salad.cloud.sdk.models.UpdateContainerGroupNetworking;
import com.salad.cloud.sdk.models.UpdateContainerLogging;
import com.salad.cloud.sdk.models.UpdateContainerRegistryAuthentication;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<String> gpuClasses = Arrays.asList("gpu_classes");

    Resources resources = Resources
      .builder()
      .cpu(12L)
      .memory(29058L)
      .gpuClasses(gpuClasses)
      .storageAmount(13215929602L)
      .build();

    List<String> command = Arrays.asList("command");

    LoggingAxiom3 loggingAxiom3 = LoggingAxiom3.builder().host("host").apiToken("api_token").dataset("dataset").build();

    DatadogTags3 datadogTags3 = DatadogTags3.builder().name("name").value("value").build();

    List<DatadogTags3> tags = Arrays.asList(datadogTags3);

    LoggingDatadog3 loggingDatadog3 = LoggingDatadog3.builder().host("host").apiKey("api_key").tags(tags).build();

    LoggingNewRelic3 loggingNewRelic3 = LoggingNewRelic3.builder().host("host").ingestionKey("ingestion_key").build();

    LoggingSplunk3 loggingSplunk3 = LoggingSplunk3.builder().host("host").token("token").build();

    LoggingTcp3 loggingTcp3 = LoggingTcp3.builder().host("host").port(26319L).build();

    HttpHeaders4 httpHeaders4 = HttpHeaders4.builder().name("name").value("value").build();

    List<HttpHeaders4> headers = Arrays.asList(httpHeaders4);

    LoggingHttp3 loggingHttp3 = LoggingHttp3
      .builder()
      .host("host")
      .port(16494L)
      .user("user")
      .password("password")
      .path("path")
      .format(HttpFormat3.JSON)
      .headers(headers)
      .compression(HttpCompression3.NONE)
      .build();

    UpdateContainerLogging updateContainerLogging = UpdateContainerLogging
      .builder()
      .axiom(loggingAxiom3)
      .datadog(loggingDatadog3)
      .newRelic(loggingNewRelic3)
      .splunk(loggingSplunk3)
      .tcp(loggingTcp3)
      .http(loggingHttp3)
      .build();

    RegistryAuthenticationBasic2 registryAuthenticationBasic2 = RegistryAuthenticationBasic2
      .builder()
      .username("username")
      .password("password")
      .build();

    RegistryAuthenticationGcpGcr2 registryAuthenticationGcpGcr2 = RegistryAuthenticationGcpGcr2
      .builder()
      .serviceKey("service_key")
      .build();

    RegistryAuthenticationAwsEcr2 registryAuthenticationAwsEcr2 = RegistryAuthenticationAwsEcr2
      .builder()
      .accessKeyId("access_key_id")
      .secretAccessKey("secret_access_key")
      .build();

    RegistryAuthenticationDockerHub2 registryAuthenticationDockerHub2 = RegistryAuthenticationDockerHub2
      .builder()
      .username("username")
      .personalAccessToken("personal_access_token")
      .build();

    RegistryAuthenticationGcpGar2 registryAuthenticationGcpGar2 = RegistryAuthenticationGcpGar2
      .builder()
      .serviceKey("service_key")
      .build();

    UpdateContainerRegistryAuthentication updateContainerRegistryAuthentication = UpdateContainerRegistryAuthentication
      .builder()
      .basic(registryAuthenticationBasic2)
      .gcpGcr(registryAuthenticationGcpGcr2)
      .awsEcr(registryAuthenticationAwsEcr2)
      .dockerHub(registryAuthenticationDockerHub2)
      .gcpGar(registryAuthenticationGcpGar2)
      .build();

    UpdateContainer updateContainer = UpdateContainer
      .builder()
      .image("image")
      .resources(resources)
      .command(command)
      .priority(ContainerGroupPriority.HIGH)
      .environmentVariables(new HashMap())
      .logging(updateContainerLogging)
      .registryAuthentication(updateContainerRegistryAuthentication)
      .build();

    List<CountryCode> countryCodes = Arrays.asList(CountryCode.AF);

    UpdateContainerGroupNetworking updateContainerGroupNetworking = UpdateContainerGroupNetworking
      .builder()
      .port(59913L)
      .build();

    ContainerGroupProbeTcp containerGroupProbeTcp = ContainerGroupProbeTcp.builder().port(9366L).build();

    ContainerGroupProbeHttpHeaders2 containerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeaders2> headers = Arrays.asList(containerGroupProbeHttpHeaders2);

    ContainerGroupProbeHttp containerGroupProbeHttp = ContainerGroupProbeHttp
      .builder()
      .path("path")
      .port(398L)
      .scheme(ContainerProbeHttpScheme.HTTP)
      .headers(headers)
      .build();

    ContainerGroupProbeGrpc containerGroupProbeGrpc = ContainerGroupProbeGrpc
      .builder()
      .service("service")
      .port(23866L)
      .build();

    List<String> command = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(command).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(1L)
      .periodSeconds(10L)
      .timeoutSeconds(30L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(8L)
      .periodSeconds(1L)
      .timeoutSeconds(1L)
      .successThreshold(1L)
      .failureThreshold(3L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(2L)
      .periodSeconds(3L)
      .timeoutSeconds(10L)
      .successThreshold(2L)
      .failureThreshold(1200L)
      .build();

    QueueAutoscaler queueAutoscaler = QueueAutoscaler
      .builder()
      .minReplicas(88L)
      .maxReplicas(197L)
      .desiredQueueLength(57L)
      .pollingPeriod(1449L)
      .maxUpscalePerMinute(85L)
      .maxDownscalePerMinute(33L)
      .build();

    UpdateContainerGroup updateContainerGroup = UpdateContainerGroup
      .builder()
      .displayName("iMQ")
      .container(updateContainer)
      .replicas(97L)
      .countryCodes(countryCodes)
      .networking(updateContainerGroupNetworking)
      .livenessProbe(containerGroupLivenessProbe)
      .readinessProbe(containerGroupReadinessProbe)
      .startupProbe(containerGroupStartupProbe)
      .queueAutoscaler(queueAutoscaler)
      .build();

    ContainerGroup response = saladCloudSdk.containerGroups.updateContainerGroup(
      "acme-corp",
      "dev-env",
      "n6eqezp9",
      updateContainerGroup
    );

    System.out.println(response);
  }
}

```

## deleteContainerGroup

Deletes a container group

- HTTP Method: `DELETE`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.deleteContainerGroup("acme-corp", "dev-env", "n6eqezp9");
  }
}

```

## startContainerGroup

Starts a container group

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/start`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.startContainerGroup(
      "acme-corp",
      "dev-env",
      "thlsybcgrlw5vvch4r1nbkygjtd6c-o-5jwj2ocq-dvad"
    );
  }
}

```

## stopContainerGroup

Stops a container group

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/stop`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.stopContainerGroup(
      "acme-corp",
      "dev-env",
      "ecp1l-tkh9w1nv5mu1-9nad5ncpxu9ccs7p0whu98gpr-228"
    );
  }
}

```

## listContainerGroupInstances

Gets the list of container group instances

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances`

**Parameters**

| Name               | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName   | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName        | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName | String | ✅       | The unique container group name                                                                                                                                                                                                                     |

**Return Type**

`ContainerGroupInstances`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstances;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstances response = saladCloudSdk.containerGroups.listContainerGroupInstances(
      "acme-corp",
      "dev-env",
      "znynn9io8wrozbled"
    );

    System.out.println(response);
  }
}

```

## getContainerGroupInstance

Gets a container group instance

- HTTP Method: `GET`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}`

**Parameters**

| Name                     | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName              | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName       | String | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupInstanceId | String | ✅       | The unique instance identifier                                                                                                                                                                                                                      |

**Return Type**

`ContainerGroupInstance`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstance;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstance response = saladCloudSdk.containerGroups.getContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "oxeoh8avj5fo61fav-9q13ml41n",
      "container_group_instance_id"
    );

    System.out.println(response);
  }
}

```

## reallocateContainerGroupInstance

Reallocates a container group instance to run on a different Salad Node

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/reallocate`

**Parameters**

| Name                     | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName              | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName       | String | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupInstanceId | String | ✅       | The unique instance identifier                                                                                                                                                                                                                      |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.reallocateContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "r1iikkkwnv9cb7ost0zds",
      "container_group_instance_id"
    );
  }
}

```

## recreateContainerGroupInstance

Stops a container, destroys it, and starts a new one without requiring the image to be downloaded again on a new Salad Node

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/recreate`

**Parameters**

| Name                     | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName              | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName       | String | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupInstanceId | String | ✅       | The unique instance identifier                                                                                                                                                                                                                      |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.recreateContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "ej-k54cvkw1mdc165omi3xku5rq3320mp4-mov2ar3q6lb3-iauy",
      "container_group_instance_id"
    );
  }
}

```

## restartContainerGroupInstance

Stops a container and restarts it on the same Salad Node

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}/restart`

**Parameters**

| Name                     | Type   | Required | Description                                                                                                                                                                                                                                         |
| :----------------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName         | String | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName              | String | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName       | String | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupInstanceId | String | ✅       | The unique instance identifier                                                                                                                                                                                                                      |

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    saladCloudSdk.containerGroups.restartContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "elwyv8cc9z7auxq8gmm5tqiz3fh3lty-n963c-nzs6rcc8qglueef-fdu",
      "container_group_instance_id"
    );
  }
}

```
