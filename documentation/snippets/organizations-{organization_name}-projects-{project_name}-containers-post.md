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
import com.salad.cloud.sdk.models.ContainerHttpLoggingConfigurationCompression2;
import com.salad.cloud.sdk.models.ContainerHttpLoggingConfigurationFormat2;
import com.salad.cloud.sdk.models.ContainerLoggingConfigurationHttp2;
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
      .format(ContainerHttpLoggingConfigurationFormat2.JSON)
      .headers(headersList)
      .compression(ContainerHttpLoggingConfigurationCompression2.NONE)
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
