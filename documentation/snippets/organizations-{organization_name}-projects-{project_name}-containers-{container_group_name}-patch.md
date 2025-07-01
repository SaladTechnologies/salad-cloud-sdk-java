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
import com.salad.cloud.sdk.models.ContainerLoggingHttpCompression;
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
    SaladCloudSdkConfig config = SaladCloudSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    SaladCloudSdk saladCloudSdk = new SaladCloudSdk(config);

    List<String> commandList = Arrays.asList("command");

    AxiomLoggingConfiguration axiomLoggingConfiguration = AxiomLoggingConfiguration.builder()
      .host("host")
      .apiToken("api_token")
      .dataset("dataset")
      .build();

    DatadogTagForContainerLogging datadogTagForContainerLogging = DatadogTagForContainerLogging.builder()
      .name("name")
      .value("value")
      .build();

    List<DatadogTagForContainerLogging> tagsList = Arrays.asList(datadogTagForContainerLogging);

    DatadogLoggingConfiguration datadogLoggingConfiguration = DatadogLoggingConfiguration.builder()
      .host("host")
      .apiKey("api_key")
      .tags(tagsList)
      .build();

    ContainerLoggingHttpHeader containerLoggingHttpHeader = ContainerLoggingHttpHeader.builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerLoggingHttpHeader> headersList = Arrays.asList(containerLoggingHttpHeader);

    ContainerLoggingConfigurationHttp1 containerLoggingConfigurationHttp1 = ContainerLoggingConfigurationHttp1.builder()
      .host("host")
      .port(34677L)
      .user("user")
      .password("password")
      .path("path")
      .format(ContainerLoggingHttpFormat.JSON)
      .headers(headersList)
      .compression(ContainerLoggingHttpCompression.NONE)
      .build();

    NewRelicLoggingConfiguration newRelicLoggingConfiguration = NewRelicLoggingConfiguration.builder()
      .host("host")
      .ingestionKey("ingestion_key")
      .build();

    ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration =
      ContainerLoggingSplunkConfiguration.builder().host("host").token("token").build();

    TcpLoggingConfiguration tcpLoggingConfiguration = TcpLoggingConfiguration.builder()
      .host("host")
      .port(21602L)
      .build();

    UpdateContainerLogging updateContainerLogging = UpdateContainerLogging.builder()
      .axiom(axiomLoggingConfiguration)
      .datadog(datadogLoggingConfiguration)
      .http(containerLoggingConfigurationHttp1)
      .newRelic(newRelicLoggingConfiguration)
      .splunk(containerLoggingSplunkConfiguration)
      .tcp(tcpLoggingConfiguration)
      .build();

    ContainerRegistryAuthenticationAwsEcr containerRegistryAuthenticationAwsEcr =
      ContainerRegistryAuthenticationAwsEcr.builder()
        .accessKeyId("access_key_id")
        .secretAccessKey("secret_access_key")
        .build();

    ContainerRegistryAuthenticationBasic containerRegistryAuthenticationBasic =
      ContainerRegistryAuthenticationBasic.builder().username("username").password("password").build();

    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub =
      ContainerRegistryAuthenticationDockerHub.builder()
        .username("username")
        .personalAccessToken("personal_access_token")
        .build();

    ContainerRegistryAuthenticationGcpGar containerRegistryAuthenticationGcpGar =
      ContainerRegistryAuthenticationGcpGar.builder().serviceKey("service_key").build();

    ContainerRegistryAuthenticationGcpGcr containerRegistryAuthenticationGcpGcr =
      ContainerRegistryAuthenticationGcpGcr.builder().serviceKey("service_key").build();

    ContainerRegistryAuthentication containerRegistryAuthentication = ContainerRegistryAuthentication.builder()
      .awsEcr(containerRegistryAuthenticationAwsEcr)
      .basic(containerRegistryAuthenticationBasic)
      .dockerHub(containerRegistryAuthenticationDockerHub)
      .gcpGar(containerRegistryAuthenticationGcpGar)
      .gcpGcr(containerRegistryAuthenticationGcpGcr)
      .build();

    List<String> gpuClassesList = Arrays.asList("gpu_classes");

    ContainerResourceUpdateSchema containerResourceUpdateSchema = ContainerResourceUpdateSchema.builder()
      .cpu(2L)
      .memory(4272L)
      .gpuClasses(gpuClassesList)
      .storageAmount(47962159632L)
      .shmSize(64L)
      .build();

    UpdateContainer updateContainer = UpdateContainer.builder()
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

    UpdateContainerGroupNetworking updateContainerGroupNetworking = UpdateContainerGroupNetworking.builder()
      .port(17663L)
      .build();

    List<String> commandList1 = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(commandList1).build();

    ContainerGroupGRpcProbe containerGroupGRpcProbe = ContainerGroupGRpcProbe.builder()
      .port(28667L)
      .service("service")
      .build();

    ContainerGroupProbeHttpHeader containerGroupProbeHttpHeader = ContainerGroupProbeHttpHeader.builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerGroupProbeHttpHeader> headersList1 = Arrays.asList(containerGroupProbeHttpHeader);

    ContainerGroupHttpProbeConfiguration containerGroupHttpProbeConfiguration =
      ContainerGroupHttpProbeConfiguration.builder()
        .headers(headersList1)
        .path("path")
        .port(53414L)
        .scheme(HttpScheme.HTTP)
        .build();

    ContainerGroupTcpProbe containerGroupTcpProbe = ContainerGroupTcpProbe.builder().port(62611L).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe.builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(67L)
      .periodSeconds(10L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(30L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe.builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(3L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(226L)
      .periodSeconds(1L)
      .successThreshold(1L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(1L)
      .build();

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe.builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(15L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(1058L)
      .tcp(containerGroupTcpProbe)
      .periodSeconds(3L)
      .successThreshold(2L)
      .timeoutSeconds(10L)
      .build();

    QueueBasedAutoscalerConfiguration queueBasedAutoscalerConfiguration = QueueBasedAutoscalerConfiguration.builder()
      .desiredQueueLength(22L)
      .maxReplicas(462L)
      .maxDownscalePerMinute(26L)
      .maxUpscalePerMinute(52L)
      .minReplicas(82L)
      .pollingPeriod(509L)
      .build();

    ContainerGroupPatch containerGroupPatch = ContainerGroupPatch.builder()
      .displayName("e2ajyqqvL")
      .container(updateContainer)
      .replicas(436L)
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
