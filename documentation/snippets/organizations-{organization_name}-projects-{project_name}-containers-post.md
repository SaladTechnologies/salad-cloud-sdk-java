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
      .cpu(13L)
      .memory(8139L)
      .gpuClasses(gpuClasses)
      .storageAmount(43769579402L)
      .build();

    List<String> command = Arrays.asList("command");

    LoggingAxiom2 loggingAxiom2 = LoggingAxiom2.builder().host("host").apiToken("api_token").dataset("dataset").build();

    DatadogTags2 datadogTags2 = DatadogTags2.builder().name("name").value("value").build();

    List<DatadogTags2> tags = Arrays.asList(datadogTags2);

    LoggingDatadog2 loggingDatadog2 = LoggingDatadog2.builder().host("host").apiKey("api_key").tags(tags).build();

    LoggingNewRelic2 loggingNewRelic2 = LoggingNewRelic2.builder().host("host").ingestionKey("ingestion_key").build();

    LoggingSplunk2 loggingSplunk2 = LoggingSplunk2.builder().host("host").token("token").build();

    LoggingTcp2 loggingTcp2 = LoggingTcp2.builder().host("host").port(24951L).build();

    HttpHeaders3 httpHeaders3 = HttpHeaders3.builder().name("name").value("value").build();

    List<HttpHeaders3> headers = Arrays.asList(httpHeaders3);

    LoggingHttp2 loggingHttp2 = LoggingHttp2
      .builder()
      .host("host")
      .port(36565L)
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
      .port(22764L)
      .auth(false)
      .loadBalancer(CreateContainerGroupNetworkingLoadBalancer.ROUND_ROBIN)
      .singleConnectionLimit(false)
      .clientRequestTimeout(100000L)
      .serverResponseTimeout(100000L)
      .build();

    ContainerGroupProbeTcp containerGroupProbeTcp = ContainerGroupProbeTcp.builder().port(22350L).build();

    ContainerGroupProbeHttpHeaders2 containerGroupProbeHttpHeaders2 = ContainerGroupProbeHttpHeaders2
      .builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeaders2> headers = Arrays.asList(containerGroupProbeHttpHeaders2);

    ContainerGroupProbeHttp containerGroupProbeHttp = ContainerGroupProbeHttp
      .builder()
      .path("path")
      .port(56884L)
      .scheme(ContainerProbeHttpScheme.HTTP)
      .headers(headers)
      .build();

    ContainerGroupProbeGrpc containerGroupProbeGrpc = ContainerGroupProbeGrpc
      .builder()
      .service("service")
      .port(47172L)
      .build();

    List<String> command = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(command).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe
      .builder()
      .tcp(containerGroupProbeTcp)
      .http(containerGroupProbeHttp)
      .grpc(containerGroupProbeGrpc)
      .exec(containerGroupProbeExec)
      .initialDelaySeconds(0L)
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
      .initialDelaySeconds(0L)
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
      .initialDelaySeconds(9L)
      .periodSeconds(3L)
      .timeoutSeconds(10L)
      .successThreshold(2L)
      .failureThreshold(1200L)
      .build();

    ContainerGroupQueueConnection containerGroupQueueConnection = ContainerGroupQueueConnection
      .builder()
      .path("path")
      .port(34605L)
      .queueName("gv8rketqh")
      .build();

    QueueAutoscaler queueAutoscaler = QueueAutoscaler
      .builder()
      .minReplicas(26L)
      .maxReplicas(28L)
      .desiredQueueLength(42L)
      .pollingPeriod(442L)
      .maxUpscalePerMinute(3L)
      .maxDownscalePerMinute(69L)
      .build();

    CreateContainerGroup createContainerGroup = CreateContainerGroup
      .builder()
      .name("name")
      .displayName("VSVi1YCcw")
      .container(createContainer)
      .autostartPolicy(false)
      .restartPolicy(ContainerRestartPolicy.ALWAYS)
      .replicas(231L)
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
