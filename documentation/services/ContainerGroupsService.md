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
| [updateContainerGroupInstance](#updatecontainergroupinstance)         | Updates a container group instance                                                                                          |
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

`ContainerGroupCollection`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupCollection;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupCollection response = saladCloudSdk.containerGroups.listContainerGroups("acme-corp", "dev-env");

    System.out.println(response);
  }
}

```

## createContainerGroup

Creates a new container group

- HTTP Method: `POST`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers`

**Parameters**

| Name                          | Type                                                                        | Required | Description                                                                                                                                                                                                                                         |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName              | String                                                                      | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName                   | String                                                                      | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupCreationRequest | [ContainerGroupCreationRequest](../models/ContainerGroupCreationRequest.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`ContainerGroup`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.AxiomLoggingConfiguration;
import com.salad.cloud.sdk.models.ContainerConfiguration;
import com.salad.cloud.sdk.models.ContainerConfigurationLogging;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupCreationRequest;
import com.salad.cloud.sdk.models.ContainerGroupGRpcProbe;
import com.salad.cloud.sdk.models.ContainerGroupHttpProbeConfiguration;
import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.models.ContainerGroupPriority;
import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.models.ContainerGroupQueueConnection;
import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.models.ContainerGroupTcpProbe;
import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp2;
import com.salad.cloud.sdk.models.ContainerLoggingHttpFormat;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.models.ContainerLoggingSplunkConfiguration;
import com.salad.cloud.sdk.models.ContainerNetworkingProtocol;
import com.salad.cloud.sdk.models.ContainerRegistryAuthentication;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationAwsEcr;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationBasic;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationDockerHub;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGar;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGcr;
import com.salad.cloud.sdk.models.ContainerResourceRequirements;
import com.salad.cloud.sdk.models.ContainerRestartPolicy;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.CreateContainerGroupNetworking;
import com.salad.cloud.sdk.models.DatadogLoggingConfiguration;
import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.models.HttpScheme;
import com.salad.cloud.sdk.models.NewRelicLoggingConfiguration;
import com.salad.cloud.sdk.models.QueueBasedAutoscalerConfiguration;
import com.salad.cloud.sdk.models.TcpLoggingConfiguration;
import com.salad.cloud.sdk.models.TheContainerGroupNetworkingLoadBalancer;
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

    List<String> commandList = Arrays.asList("command");

    AxiomLoggingConfiguration axiomLoggingConfiguration = AxiomLoggingConfiguration
      .builder()
      .host("host")
      .apiToken("api_token")
      .dataset("dataset")
      .build();

    DatadogTagForContainerLogging datadogTagForContainerLogging = DatadogTagForContainerLogging
      .builder()
      .name("name")
      .value("value")
      .build();

    List<DatadogTagForContainerLogging> tagsList = Arrays.asList(datadogTagForContainerLogging);

    DatadogLoggingConfiguration datadogLoggingConfiguration = DatadogLoggingConfiguration
      .builder()
      .host("host")
      .apiKey("api_key")
      .tags(tagsList)
      .build();

    ContainerLoggingHttpHeader containerLoggingHttpHeader = ContainerLoggingHttpHeader
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerLoggingHttpHeader> headersList = Arrays.asList(containerLoggingHttpHeader);

    ContainerLoggingConfigurationHttp2 containerLoggingConfigurationHttp2 = ContainerLoggingConfigurationHttp2
      .builder()
      .host("host")
      .port(46840L)
      .user("user")
      .password("password")
      .path("path")
      .format(ContainerLoggingHttpFormat.JSON)
      .headers(headersList)
      .compression(new Object())
      .build();

    NewRelicLoggingConfiguration newRelicLoggingConfiguration = NewRelicLoggingConfiguration
      .builder()
      .host("host")
      .ingestionKey("ingestion_key")
      .build();

    ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration = ContainerLoggingSplunkConfiguration
      .builder()
      .host("host")
      .token("token")
      .build();

    TcpLoggingConfiguration tcpLoggingConfiguration = TcpLoggingConfiguration
      .builder()
      .host("host")
      .port(44671L)
      .build();

    ContainerConfigurationLogging containerConfigurationLogging = ContainerConfigurationLogging
      .builder()
      .axiom(axiomLoggingConfiguration)
      .datadog(datadogLoggingConfiguration)
      .http(containerLoggingConfigurationHttp2)
      .newRelic(newRelicLoggingConfiguration)
      .splunk(containerLoggingSplunkConfiguration)
      .tcp(tcpLoggingConfiguration)
      .build();

    ContainerRegistryAuthenticationAwsEcr containerRegistryAuthenticationAwsEcr = ContainerRegistryAuthenticationAwsEcr
      .builder()
      .accessKeyId("access_key_id")
      .secretAccessKey("secret_access_key")
      .build();

    ContainerRegistryAuthenticationBasic containerRegistryAuthenticationBasic = ContainerRegistryAuthenticationBasic
      .builder()
      .username("username")
      .password("password")
      .build();

    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub =
      ContainerRegistryAuthenticationDockerHub
        .builder()
        .username("username")
        .personalAccessToken("personal_access_token")
        .build();

    ContainerRegistryAuthenticationGcpGar containerRegistryAuthenticationGcpGar = ContainerRegistryAuthenticationGcpGar
      .builder()
      .serviceKey("service_key")
      .build();

    ContainerRegistryAuthenticationGcpGcr containerRegistryAuthenticationGcpGcr = ContainerRegistryAuthenticationGcpGcr
      .builder()
      .serviceKey("service_key")
      .build();

    ContainerRegistryAuthentication containerRegistryAuthentication = ContainerRegistryAuthentication
      .builder()
      .awsEcr(containerRegistryAuthenticationAwsEcr)
      .basic(containerRegistryAuthenticationBasic)
      .dockerHub(containerRegistryAuthenticationDockerHub)
      .gcpGar(containerRegistryAuthenticationGcpGar)
      .gcpGcr(containerRegistryAuthenticationGcpGcr)
      .build();

    List<String> gpuClassesList = Arrays.asList("gpu_classes");

    ContainerResourceRequirements containerResourceRequirements = ContainerResourceRequirements
      .builder()
      .cpu(2L)
      .memory(57018L)
      .gpuClasses(gpuClassesList)
      .storageAmount(10190895817L)
      .build();

    ContainerConfiguration containerConfiguration = ContainerConfiguration
      .builder()
      .command(commandList)
      .environmentVariables(new HashMap())
      .image("acme/:latest")
      .imageCaching(true)
      .logging(containerConfigurationLogging)
      .priority(ContainerGroupPriority.HIGH)
      .registryAuthentication(containerRegistryAuthentication)
      .resources(containerResourceRequirements)
      .build();

    List<CountryCode> countryCodesList = Arrays.asList(CountryCode.AF);

    List<String> commandList1 = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(commandList1).build();

    ContainerGroupGRpcProbe containerGroupGRpcProbe = ContainerGroupGRpcProbe
      .builder()
      .port(37648L)
      .service("service")
      .build();

    ContainerGroupProbeHttpHeader containerGroupProbeHttpHeader = ContainerGroupProbeHttpHeader
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeader> headersList1 = Arrays.asList(containerGroupProbeHttpHeader);

    ContainerGroupHttpProbeConfiguration containerGroupHttpProbeConfiguration = ContainerGroupHttpProbeConfiguration
      .builder()
      .headers(headersList1)
      .path("path")
      .port(29069L)
      .scheme(HttpScheme.HTTP)
      .build();

    ContainerGroupTcpProbe containerGroupTcpProbe = ContainerGroupTcpProbe.builder().port(13817L).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(670L)
      .periodSeconds(10L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(30L)
      .build();

    CreateContainerGroupNetworking createContainerGroupNetworking = CreateContainerGroupNetworking
      .builder()
      .auth(false)
      .clientRequestTimeout(100000L)
      .loadBalancer(TheContainerGroupNetworkingLoadBalancer.ROUND_ROBIN)
      .port(60000L)
      .protocol(ContainerNetworkingProtocol.HTTP)
      .serverResponseTimeout(100000L)
      .singleConnectionLimit(true)
      .build();

    QueueBasedAutoscalerConfiguration queueBasedAutoscalerConfiguration = QueueBasedAutoscalerConfiguration
      .builder()
      .desiredQueueLength(53L)
      .maxReplicas(291L)
      .maxDownscalePerMinute(65L)
      .maxUpscalePerMinute(100L)
      .minReplicas(54L)
      .pollingPeriod(140L)
      .build();

    ContainerGroupQueueConnection containerGroupQueueConnection = ContainerGroupQueueConnection
      .builder()
      .path("path")
      .port(47568L)
      .queueName("z1h-3z01x9")
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(262L)
      .periodSeconds(1L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(1L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(15L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(1106L)
      .tcp(containerGroupTcpProbe)
      .periodSeconds(3L)
      .successThreshold(2L)
      .timeoutSeconds(10L)
      .build();

    ContainerGroupCreationRequest containerGroupCreationRequest = ContainerGroupCreationRequest
      .builder()
      .autostartPolicy(false)
      .container(containerConfiguration)
      .countryCodes(countryCodesList)
      .displayName("9 Q592CH6F")
      .livenessProbe(containerGroupLivenessProbe)
      .name("name")
      .networking(createContainerGroupNetworking)
      .queueAutoscaler(queueBasedAutoscalerConfiguration)
      .queueConnection(containerGroupQueueConnection)
      .readinessProbe(containerGroupReadinessProbe)
      .replicas(284L)
      .restartPolicy(ContainerRestartPolicy.ALWAYS)
      .startupProbe(containerGroupStartupProbe)
      .build();

    ContainerGroup response = saladCloudSdk.containerGroups.createContainerGroup(
      "acme-corp",
      "dev-env",
      containerGroupCreationRequest
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

    ContainerGroup response = saladCloudSdk.containerGroups.getContainerGroup("acme-corp", "dev-env", "mandlebrot");

    System.out.println(response);
  }
}

```

## updateContainerGroup

Updates a container group

- HTTP Method: `PATCH`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}`

**Parameters**

| Name                | Type                                                    | Required | Description                                                                                                                                                                                                                                         |
| :------------------ | :------------------------------------------------------ | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName    | String                                                  | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName         | String                                                  | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName  | String                                                  | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupPatch | [ContainerGroupPatch](../models/ContainerGroupPatch.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`ContainerGroup`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.AxiomLoggingConfiguration;
import com.salad.cloud.sdk.models.ContainerGroup;
import com.salad.cloud.sdk.models.ContainerGroupGRpcProbe;
import com.salad.cloud.sdk.models.ContainerGroupHttpProbeConfiguration;
import com.salad.cloud.sdk.models.ContainerGroupLivenessProbe;
import com.salad.cloud.sdk.models.ContainerGroupPatch;
import com.salad.cloud.sdk.models.ContainerGroupPriority;
import com.salad.cloud.sdk.models.ContainerGroupProbeExec;
import com.salad.cloud.sdk.models.ContainerGroupProbeHttpHeader;
import com.salad.cloud.sdk.models.ContainerGroupReadinessProbe;
import com.salad.cloud.sdk.models.ContainerGroupStartupProbe;
import com.salad.cloud.sdk.models.ContainerGroupTcpProbe;
import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp1;
import com.salad.cloud.sdk.models.ContainerLoggingHttpFormat;
import com.salad.cloud.sdk.models.ContainerLoggingHttpHeader;
import com.salad.cloud.sdk.models.ContainerLoggingSplunkConfiguration;
import com.salad.cloud.sdk.models.ContainerRegistryAuthentication;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationAwsEcr;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationBasic;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationDockerHub;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGar;
import com.salad.cloud.sdk.models.ContainerRegistryAuthenticationGcpGcr;
import com.salad.cloud.sdk.models.ContainerResourceUpdateSchema;
import com.salad.cloud.sdk.models.CountryCode;
import com.salad.cloud.sdk.models.DatadogLoggingConfiguration;
import com.salad.cloud.sdk.models.DatadogTagForContainerLogging;
import com.salad.cloud.sdk.models.HttpScheme;
import com.salad.cloud.sdk.models.NewRelicLoggingConfiguration;
import com.salad.cloud.sdk.models.QueueBasedAutoscalerConfiguration;
import com.salad.cloud.sdk.models.TcpLoggingConfiguration;
import com.salad.cloud.sdk.models.UpdateContainer;
import com.salad.cloud.sdk.models.UpdateContainerGroupNetworking;
import com.salad.cloud.sdk.models.UpdateContainerLogging;
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

    List<String> commandList = Arrays.asList("command");

    AxiomLoggingConfiguration axiomLoggingConfiguration = AxiomLoggingConfiguration
      .builder()
      .host("host")
      .apiToken("api_token")
      .dataset("dataset")
      .build();

    DatadogTagForContainerLogging datadogTagForContainerLogging = DatadogTagForContainerLogging
      .builder()
      .name("name")
      .value("value")
      .build();

    List<DatadogTagForContainerLogging> tagsList = Arrays.asList(datadogTagForContainerLogging);

    DatadogLoggingConfiguration datadogLoggingConfiguration = DatadogLoggingConfiguration
      .builder()
      .host("host")
      .apiKey("api_key")
      .tags(tagsList)
      .build();

    ContainerLoggingHttpHeader containerLoggingHttpHeader = ContainerLoggingHttpHeader
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerLoggingHttpHeader> headersList = Arrays.asList(containerLoggingHttpHeader);

    ContainerLoggingConfigurationHttp1 containerLoggingConfigurationHttp1 = ContainerLoggingConfigurationHttp1
      .builder()
      .host("host")
      .port(55354L)
      .user("user")
      .password("password")
      .path("path")
      .format(ContainerLoggingHttpFormat.JSON)
      .headers(headersList)
      .compression(new Object())
      .build();

    NewRelicLoggingConfiguration newRelicLoggingConfiguration = NewRelicLoggingConfiguration
      .builder()
      .host("host")
      .ingestionKey("ingestion_key")
      .build();

    ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration = ContainerLoggingSplunkConfiguration
      .builder()
      .host("host")
      .token("token")
      .build();

    TcpLoggingConfiguration tcpLoggingConfiguration = TcpLoggingConfiguration
      .builder()
      .host("host")
      .port(44671L)
      .build();

    UpdateContainerLogging updateContainerLogging = UpdateContainerLogging
      .builder()
      .axiom(axiomLoggingConfiguration)
      .datadog(datadogLoggingConfiguration)
      .http(containerLoggingConfigurationHttp1)
      .newRelic(newRelicLoggingConfiguration)
      .splunk(containerLoggingSplunkConfiguration)
      .tcp(tcpLoggingConfiguration)
      .build();

    ContainerRegistryAuthenticationAwsEcr containerRegistryAuthenticationAwsEcr = ContainerRegistryAuthenticationAwsEcr
      .builder()
      .accessKeyId("access_key_id")
      .secretAccessKey("secret_access_key")
      .build();

    ContainerRegistryAuthenticationBasic containerRegistryAuthenticationBasic = ContainerRegistryAuthenticationBasic
      .builder()
      .username("username")
      .password("password")
      .build();

    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub =
      ContainerRegistryAuthenticationDockerHub
        .builder()
        .username("username")
        .personalAccessToken("personal_access_token")
        .build();

    ContainerRegistryAuthenticationGcpGar containerRegistryAuthenticationGcpGar = ContainerRegistryAuthenticationGcpGar
      .builder()
      .serviceKey("service_key")
      .build();

    ContainerRegistryAuthenticationGcpGcr containerRegistryAuthenticationGcpGcr = ContainerRegistryAuthenticationGcpGcr
      .builder()
      .serviceKey("service_key")
      .build();

    ContainerRegistryAuthentication containerRegistryAuthentication = ContainerRegistryAuthentication
      .builder()
      .awsEcr(containerRegistryAuthenticationAwsEcr)
      .basic(containerRegistryAuthenticationBasic)
      .dockerHub(containerRegistryAuthenticationDockerHub)
      .gcpGar(containerRegistryAuthenticationGcpGar)
      .gcpGcr(containerRegistryAuthenticationGcpGcr)
      .build();

    List<String> gpuClassesList = Arrays.asList("gpu_classes");

    ContainerResourceUpdateSchema containerResourceUpdateSchema = ContainerResourceUpdateSchema
      .builder()
      .cpu(6L)
      .memory(56406L)
      .gpuClasses(gpuClassesList)
      .storageAmount(7030693392L)
      .build();

    UpdateContainer updateContainer = UpdateContainer
      .builder()
      .command(commandList)
      .environmentVariables(new HashMap())
      .image("image")
      .imageCaching(true)
      .logging(updateContainerLogging)
      .priority(ContainerGroupPriority.HIGH)
      .registryAuthentication(containerRegistryAuthentication)
      .resources(containerResourceUpdateSchema)
      .build();

    List<CountryCode> countryCodesList = Arrays.asList(CountryCode.AF);

    UpdateContainerGroupNetworking updateContainerGroupNetworking = UpdateContainerGroupNetworking
      .builder()
      .port(45473L)
      .build();

    List<String> commandList1 = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(commandList1).build();

    ContainerGroupGRpcProbe containerGroupGRpcProbe = ContainerGroupGRpcProbe
      .builder()
      .port(37648L)
      .service("service")
      .build();

    ContainerGroupProbeHttpHeader containerGroupProbeHttpHeader = ContainerGroupProbeHttpHeader
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeader> headersList1 = Arrays.asList(containerGroupProbeHttpHeader);

    ContainerGroupHttpProbeConfiguration containerGroupHttpProbeConfiguration = ContainerGroupHttpProbeConfiguration
      .builder()
      .headers(headersList1)
      .path("path")
      .port(29069L)
      .scheme(HttpScheme.HTTP)
      .build();

    ContainerGroupTcpProbe containerGroupTcpProbe = ContainerGroupTcpProbe.builder().port(13817L).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(670L)
      .periodSeconds(10L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(30L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(262L)
      .periodSeconds(1L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(1L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe
      .builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(15L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(1106L)
      .tcp(containerGroupTcpProbe)
      .periodSeconds(3L)
      .successThreshold(2L)
      .timeoutSeconds(10L)
      .build();

    QueueBasedAutoscalerConfiguration queueBasedAutoscalerConfiguration = QueueBasedAutoscalerConfiguration
      .builder()
      .desiredQueueLength(53L)
      .maxReplicas(291L)
      .maxDownscalePerMinute(65L)
      .maxUpscalePerMinute(100L)
      .minReplicas(54L)
      .pollingPeriod(140L)
      .build();

    ContainerGroupPatch containerGroupPatch = ContainerGroupPatch
      .builder()
      .displayName("Jjdnvuz")
      .container(updateContainer)
      .replicas(100L)
      .countryCodes(countryCodesList)
      .networking(updateContainerGroupNetworking)
      .livenessProbe(containerGroupLivenessProbe)
      .readinessProbe(containerGroupReadinessProbe)
      .startupProbe(containerGroupStartupProbe)
      .queueAutoscaler(queueBasedAutoscalerConfiguration)
      .build();

    ContainerGroup response = saladCloudSdk.containerGroups.updateContainerGroup(
      "acme-corp",
      "dev-env",
      "mandlebrot",
      containerGroupPatch
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

    saladCloudSdk.containerGroups.deleteContainerGroup("acme-corp", "dev-env", "mandlebrot");
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

    saladCloudSdk.containerGroups.startContainerGroup("acme-corp", "dev-env", "mandlebrot");
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

    saladCloudSdk.containerGroups.stopContainerGroup("acme-corp", "dev-env", "mandlebrot");
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

`ContainerGroupInstanceCollection`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstanceCollection;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstanceCollection response = saladCloudSdk.containerGroups.listContainerGroupInstances(
      "acme-corp",
      "dev-env",
      "mandlebrot"
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
| containerGroupInstanceId | String | ✅       | The unique container group instance identifier                                                                                                                                                                                                      |

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
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100"
    );

    System.out.println(response);
  }
}

```

## updateContainerGroupInstance

Updates a container group instance

- HTTP Method: `PATCH`
- Endpoint: `/organizations/{organization_name}/projects/{project_name}/containers/{container_group_name}/instances/{container_group_instance_id}`

**Parameters**

| Name                        | Type                                                                    | Required | Description                                                                                                                                                                                                                                         |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| organizationName            | String                                                                  | ✅       | Your organization name. This identifies the billing context for the API operation and represents a security boundary for SaladCloud resources. The organization must be created before using the API, and you must be a member of the organization. |
| projectName                 | String                                                                  | ✅       | Your project name. This represents a collection of related SaladCloud resources. The project must be created before using the API.                                                                                                                  |
| containerGroupName          | String                                                                  | ✅       | The unique container group name                                                                                                                                                                                                                     |
| containerGroupInstanceId    | String                                                                  | ✅       | The unique container group instance identifier                                                                                                                                                                                                      |
| containerGroupInstancePatch | [ContainerGroupInstancePatch](../models/ContainerGroupInstancePatch.md) | ✅       | Request Body                                                                                                                                                                                                                                        |

**Return Type**

`ContainerGroupInstance`

**Example Usage Code Snippet**

```java
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstance;
import com.salad.cloud.sdk.models.ContainerGroupInstancePatch;

public class Main {

  public static void main(String[] args) {
    SaladCloudSdkConfig config = SaladCloudSdkConfig
      .builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    ContainerGroupInstancePatch containerGroupInstancePatch = ContainerGroupInstancePatch
      .builder()
      .deletionCost(82294L)
      .build();

    ContainerGroupInstance response = saladCloudSdk.containerGroups.updateContainerGroupInstance(
      "acme-corp",
      "dev-env",
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100",
      containerGroupInstancePatch
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
| containerGroupInstanceId | String | ✅       | The unique container group instance identifier                                                                                                                                                                                                      |

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
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100"
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
| containerGroupInstanceId | String | ✅       | The unique container group instance identifier                                                                                                                                                                                                      |

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
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100"
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
| containerGroupInstanceId | String | ✅       | The unique container group instance identifier                                                                                                                                                                                                      |

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
      "mandlebrot",
      "db3a4591-efc3-46c0-b06a-3d820c0ec100"
    );
  }
}

```
