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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupList;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: ContainerGroupList = saladCloudSdk.containerGroups.listContainerGroups("acme-corp", "dev-env");

    println(response);
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

```kotlin
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

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val gpuClasses: List<String> = Arrays.asList("gpu_classes");

		val containerResourceRequirements: ContainerResourceRequirements = ContainerResourceRequirements.builder()
			.cpu(14L)
			.memory(39206L)
			.gpuClasses(gpuClasses)
			.storageAmount(21142065650L)
			.build();

		val command: List<String> = Arrays.asList("command");

		val loggingAxiom2: LoggingAxiom2 = LoggingAxiom2.builder()
			.host("host")
			.apiToken("api_token")
			.dataset("dataset")
			.build();

		val datadogTags2: DatadogTags2 = DatadogTags2.builder()
			.name("name")
			.value("value")
			.build();

		val tags: List<DatadogTags2> = Arrays.asList(datadogTags2);

		val loggingDatadog2: LoggingDatadog2 = LoggingDatadog2.builder()
			.host("host")
			.apiKey("api_key")
			.tags(tags)
			.build();

		val loggingNewRelic2: LoggingNewRelic2 = LoggingNewRelic2.builder()
			.host("host")
			.ingestionKey("ingestion_key")
			.build();

		val loggingSplunk2: LoggingSplunk2 = LoggingSplunk2.builder()
			.host("host")
			.token("token")
			.build();

		val loggingTcp2: LoggingTcp2 = LoggingTcp2.builder()
			.host("host")
			.port(18162L)
			.build();

		val httpHeaders3: HttpHeaders3 = HttpHeaders3.builder()
			.name("name")
			.value("value")
			.build();

		val headers: List<HttpHeaders3> = Arrays.asList(httpHeaders3);

		val loggingHttp2: LoggingHttp2 = LoggingHttp2.builder()
			.host("host")
			.port(9845L)
			.user("user")
			.password("password")
			.path("path")
			.format(HttpFormat2.JSON)
			.headers(headers)
			.compression(HttpCompression2.NONE)
			.build();

		val createContainerLogging: CreateContainerLogging = CreateContainerLogging.builder()
			.axiom(loggingAxiom2)
			.datadog(loggingDatadog2)
			.newRelic(loggingNewRelic2)
			.splunk(loggingSplunk2)
			.tcp(loggingTcp2)
			.http(loggingHttp2)
			.build();

		val registryAuthenticationBasic1: RegistryAuthenticationBasic1 = RegistryAuthenticationBasic1.builder()
			.username("username")
			.password("password")
			.build();

		val registryAuthenticationGcpGcr1: RegistryAuthenticationGcpGcr1 = RegistryAuthenticationGcpGcr1.builder()
			.serviceKey("service_key")
			.build();

		val registryAuthenticationAwsEcr1: RegistryAuthenticationAwsEcr1 = RegistryAuthenticationAwsEcr1.builder()
			.accessKeyId("access_key_id")
			.secretAccessKey("secret_access_key")
			.build();

		val registryAuthenticationDockerHub1: RegistryAuthenticationDockerHub1 = RegistryAuthenticationDockerHub1.builder()
			.username("username")
			.personalAccessToken("personal_access_token")
			.build();

		val registryAuthenticationGcpGar1: RegistryAuthenticationGcpGar1 = RegistryAuthenticationGcpGar1.builder()
			.serviceKey("service_key")
			.build();

		val createContainerRegistryAuthentication: CreateContainerRegistryAuthentication = CreateContainerRegistryAuthentication.builder()
			.basic(registryAuthenticationBasic1)
			.gcpGcr(registryAuthenticationGcpGcr1)
			.awsEcr(registryAuthenticationAwsEcr1)
			.dockerHub(registryAuthenticationDockerHub1)
			.gcpGar(registryAuthenticationGcpGar1)
			.build();

		val createContainer: CreateContainer = CreateContainer.builder()
			.image("image")
			.resources(containerResourceRequirements)
			.command(command)
			.priority(ContainerGroupPriority.HIGH)
			.environmentVariables(HashMap())
			.logging(createContainerLogging)
			.registryAuthentication(createContainerRegistryAuthentication)
			.imageCaching(false)
			.build();

		val countryCodes: List<CountryCode> = Arrays.asList(CountryCode.AF);

		val createContainerGroupNetworking: CreateContainerGroupNetworking = CreateContainerGroupNetworking.builder()
			.protocol(ContainerNetworkingProtocol.HTTP)
			.port(12950L)
			.auth(false)
			.loadBalancer(CreateContainerGroupNetworkingLoadBalancer.ROUND_ROBIN)
			.singleConnectionLimit(true)
			.clientRequestTimeout(100000L)
			.serverResponseTimeout(100000L)
			.build();

		val containerGroupProbeTcp: ContainerGroupProbeTcp = ContainerGroupProbeTcp.builder()
			.port(48638L)
			.build();

		val containerGroupProbeHttpHeaders2: ContainerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2.builder()
			.name("name")
			.value("value")
			.build();

		val headers: List<ContainerGroupProbeHttpHeaders2> = Arrays.asList(containerGroupProbeHttpHeaders2);

		val containerGroupProbeHttp: ContainerGroupProbeHttp = ContainerGroupProbeHttp.builder()
			.path("path")
			.port(19938L)
			.scheme(ContainerProbeHttpScheme.HTTP)
			.headers(headers)
			.build();

		val containerGroupProbeGrpc: ContainerGroupProbeGrpc = ContainerGroupProbeGrpc.builder()
			.service("service")
			.port(56724L)
			.build();

		val command: List<String> = Arrays.asList("command");

		val containerGroupProbeExec: ContainerGroupProbeExec = ContainerGroupProbeExec.builder()
			.command(command)
			.build();

		val containerGroupLivenessProbe: ContainerGroupLivenessProbe = ContainerGroupLivenessProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(7L)
			.periodSeconds(10L)
			.timeoutSeconds(30L)
			.successThreshold(1L)
			.failureThreshold(3L)
			.build();

		val containerGroupReadinessProbe: ContainerGroupReadinessProbe = ContainerGroupReadinessProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(2L)
			.periodSeconds(1L)
			.timeoutSeconds(1L)
			.successThreshold(1L)
			.failureThreshold(3L)
			.build();

		val containerGroupStartupProbe: ContainerGroupStartupProbe = ContainerGroupStartupProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(10L)
			.periodSeconds(3L)
			.timeoutSeconds(10L)
			.successThreshold(2L)
			.failureThreshold(1200L)
			.build();

		val containerGroupQueueConnection: ContainerGroupQueueConnection = ContainerGroupQueueConnection.builder()
			.path("path")
			.port(55927L)
			.queueName("pihwp4ho850l3faynnuq71ru6yrogza-e8llajq25o2")
			.build();

		val queueAutoscaler: QueueAutoscaler = QueueAutoscaler.builder()
			.minReplicas(94L)
			.maxReplicas(15L)
			.desiredQueueLength(98L)
			.pollingPeriod(1417L)
			.maxUpscalePerMinute(93L)
			.maxDownscalePerMinute(43L)
			.build();

		val createContainerGroup: CreateContainerGroup = CreateContainerGroup.builder()
			.name("name")
			.displayName("AZC")
			.container(createContainer)
			.autostartPolicy(true)
			.restartPolicy(ContainerRestartPolicy.ALWAYS)
			.replicas(236L)
			.countryCodes(countryCodes)
			.networking(createContainerGroupNetworking)
			.livenessProbe(containerGroupLivenessProbe)
			.readinessProbe(containerGroupReadinessProbe)
			.startupProbe(containerGroupStartupProbe)
			.queueConnection(containerGroupQueueConnection)
			.queueAutoscaler(queueAutoscaler)
			.build();

    val response: ContainerGroup = saladCloudSdk.containerGroups.createContainerGroup("acme-corp", "dev-env", createContainerGroup);

    println(response);
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroup;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: ContainerGroup = saladCloudSdk.containerGroups.getContainerGroup("acme-corp", "dev-env", "nx30k5tue7r3q30x0anq7hd1fjfxgtq8uehil3eploo4d79h7bg0v");

    println(response);
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

```kotlin
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

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val gpuClasses: List<String> = Arrays.asList("gpu_classes");

		val resources: Resources = Resources.builder()
			.cpu(4L)
			.memory(42436L)
			.gpuClasses(gpuClasses)
			.storageAmount(46147219728L)
			.build();

		val command: List<String> = Arrays.asList("command");

		val loggingAxiom3: LoggingAxiom3 = LoggingAxiom3.builder()
			.host("host")
			.apiToken("api_token")
			.dataset("dataset")
			.build();

		val datadogTags3: DatadogTags3 = DatadogTags3.builder()
			.name("name")
			.value("value")
			.build();

		val tags: List<DatadogTags3> = Arrays.asList(datadogTags3);

		val loggingDatadog3: LoggingDatadog3 = LoggingDatadog3.builder()
			.host("host")
			.apiKey("api_key")
			.tags(tags)
			.build();

		val loggingNewRelic3: LoggingNewRelic3 = LoggingNewRelic3.builder()
			.host("host")
			.ingestionKey("ingestion_key")
			.build();

		val loggingSplunk3: LoggingSplunk3 = LoggingSplunk3.builder()
			.host("host")
			.token("token")
			.build();

		val loggingTcp3: LoggingTcp3 = LoggingTcp3.builder()
			.host("host")
			.port(27612L)
			.build();

		val httpHeaders4: HttpHeaders4 = HttpHeaders4.builder()
			.name("name")
			.value("value")
			.build();

		val headers: List<HttpHeaders4> = Arrays.asList(httpHeaders4);

		val loggingHttp3: LoggingHttp3 = LoggingHttp3.builder()
			.host("host")
			.port(41733L)
			.user("user")
			.password("password")
			.path("path")
			.format(HttpFormat3.JSON)
			.headers(headers)
			.compression(HttpCompression3.NONE)
			.build();

		val updateContainerLogging: UpdateContainerLogging = UpdateContainerLogging.builder()
			.axiom(loggingAxiom3)
			.datadog(loggingDatadog3)
			.newRelic(loggingNewRelic3)
			.splunk(loggingSplunk3)
			.tcp(loggingTcp3)
			.http(loggingHttp3)
			.build();

		val registryAuthenticationBasic2: RegistryAuthenticationBasic2 = RegistryAuthenticationBasic2.builder()
			.username("username")
			.password("password")
			.build();

		val registryAuthenticationGcpGcr2: RegistryAuthenticationGcpGcr2 = RegistryAuthenticationGcpGcr2.builder()
			.serviceKey("service_key")
			.build();

		val registryAuthenticationAwsEcr2: RegistryAuthenticationAwsEcr2 = RegistryAuthenticationAwsEcr2.builder()
			.accessKeyId("access_key_id")
			.secretAccessKey("secret_access_key")
			.build();

		val registryAuthenticationDockerHub2: RegistryAuthenticationDockerHub2 = RegistryAuthenticationDockerHub2.builder()
			.username("username")
			.personalAccessToken("personal_access_token")
			.build();

		val registryAuthenticationGcpGar2: RegistryAuthenticationGcpGar2 = RegistryAuthenticationGcpGar2.builder()
			.serviceKey("service_key")
			.build();

		val updateContainerRegistryAuthentication: UpdateContainerRegistryAuthentication = UpdateContainerRegistryAuthentication.builder()
			.basic(registryAuthenticationBasic2)
			.gcpGcr(registryAuthenticationGcpGcr2)
			.awsEcr(registryAuthenticationAwsEcr2)
			.dockerHub(registryAuthenticationDockerHub2)
			.gcpGar(registryAuthenticationGcpGar2)
			.build();

		val updateContainer: UpdateContainer = UpdateContainer.builder()
			.image("image")
			.resources(resources)
			.command(command)
			.priority(ContainerGroupPriority.HIGH)
			.environmentVariables(HashMap())
			.logging(updateContainerLogging)
			.registryAuthentication(updateContainerRegistryAuthentication)
			.imageCaching(false)
			.build();

		val countryCodes: List<CountryCode> = Arrays.asList(CountryCode.AF);

		val updateContainerGroupNetworking: UpdateContainerGroupNetworking = UpdateContainerGroupNetworking.builder()
			.port(15426L)
			.build();

		val containerGroupProbeTcp: ContainerGroupProbeTcp = ContainerGroupProbeTcp.builder()
			.port(48638L)
			.build();

		val containerGroupProbeHttpHeaders2: ContainerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2.builder()
			.name("name")
			.value("value")
			.build();

		val headers: List<ContainerGroupProbeHttpHeaders2> = Arrays.asList(containerGroupProbeHttpHeaders2);

		val containerGroupProbeHttp: ContainerGroupProbeHttp = ContainerGroupProbeHttp.builder()
			.path("path")
			.port(19938L)
			.scheme(ContainerProbeHttpScheme.HTTP)
			.headers(headers)
			.build();

		val containerGroupProbeGrpc: ContainerGroupProbeGrpc = ContainerGroupProbeGrpc.builder()
			.service("service")
			.port(56724L)
			.build();

		val command: List<String> = Arrays.asList("command");

		val containerGroupProbeExec: ContainerGroupProbeExec = ContainerGroupProbeExec.builder()
			.command(command)
			.build();

		val containerGroupLivenessProbe: ContainerGroupLivenessProbe = ContainerGroupLivenessProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(7L)
			.periodSeconds(10L)
			.timeoutSeconds(30L)
			.successThreshold(1L)
			.failureThreshold(3L)
			.build();

		val containerGroupReadinessProbe: ContainerGroupReadinessProbe = ContainerGroupReadinessProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(2L)
			.periodSeconds(1L)
			.timeoutSeconds(1L)
			.successThreshold(1L)
			.failureThreshold(3L)
			.build();

		val containerGroupStartupProbe: ContainerGroupStartupProbe = ContainerGroupStartupProbe.builder()
			.tcp(containerGroupProbeTcp)
			.http(containerGroupProbeHttp)
			.grpc(containerGroupProbeGrpc)
			.exec(containerGroupProbeExec)
			.initialDelaySeconds(10L)
			.periodSeconds(3L)
			.timeoutSeconds(10L)
			.successThreshold(2L)
			.failureThreshold(1200L)
			.build();

		val queueAutoscaler: QueueAutoscaler = QueueAutoscaler.builder()
			.minReplicas(94L)
			.maxReplicas(15L)
			.desiredQueueLength(98L)
			.pollingPeriod(1417L)
			.maxUpscalePerMinute(93L)
			.maxDownscalePerMinute(43L)
			.build();

		val updateContainerGroup: UpdateContainerGroup = UpdateContainerGroup.builder()
			.displayName("K7P1u")
			.container(updateContainer)
			.replicas(308L)
			.countryCodes(countryCodes)
			.networking(updateContainerGroupNetworking)
			.livenessProbe(containerGroupLivenessProbe)
			.readinessProbe(containerGroupReadinessProbe)
			.startupProbe(containerGroupStartupProbe)
			.queueAutoscaler(queueAutoscaler)
			.build();

    val response: ContainerGroup = saladCloudSdk.containerGroups.updateContainerGroup("acme-corp", "dev-env", "nx30k5tue7r3q30x0anq7hd1fjfxgtq8uehil3eploo4d79h7bg0v", updateContainerGroup);

    println(response);
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.deleteContainerGroup("acme-corp", "dev-env", "nx30k5tue7r3q30x0anq7hd1fjfxgtq8uehil3eploo4d79h7bg0v");
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.startContainerGroup("acme-corp", "dev-env", "i5w");
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.stopContainerGroup("acme-corp", "dev-env", "kcvb9628akhug9lnd3c1w-4bdb9jsi9");
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstances;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: ContainerGroupInstances = saladCloudSdk.containerGroups.listContainerGroupInstances("acme-corp", "dev-env", "dxex70mdgjf5n-5ua-e28xyu9ujbls0vsz6xilo12xl52y9c");

    println(response);
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;
import com.salad.cloud.sdk.models.ContainerGroupInstance;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    val response: ContainerGroupInstance = saladCloudSdk.containerGroups.getContainerGroupInstance("acme-corp", "dev-env", "cdya6ykpby-hunb0b6s7s2l", "container_group_instance_id");

    println(response);
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.reallocateContainerGroupInstance("acme-corp", "dev-env", "kfvzd5f4eycptsdkpj0zrs3vycqv", "container_group_instance_id");
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.recreateContainerGroupInstance("acme-corp", "dev-env", "mk0yct7b8bo1g8tvl9", "container_group_instance_id");
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

```kotlin
import com.salad.cloud.sdk.SaladCloudSdk;
import com.salad.cloud.sdk.config.ApiKeyAuthConfig;
import com.salad.cloud.sdk.config.SaladCloudSdkConfig;

fun main() {
	val config: SaladCloudSdkConfig = SaladCloudSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

    val saladCloudSdk: SaladCloudSdk = SaladCloudSdk(config);

    saladCloudSdk.containerGroups.restartContainerGroupInstance("acme-corp", "dev-env", "ax4qyju9jcnr3fw8e9al8o-4oreg5ocaz2jbu5pfmpygxffsf4bh4e6", "container_group_instance_id");
}
```
