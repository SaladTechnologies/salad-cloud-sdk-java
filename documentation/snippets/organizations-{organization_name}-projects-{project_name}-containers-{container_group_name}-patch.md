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
import com.salad.cloud.sdk.models.ContainerGroupScalingAction;
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
      .apiToken("api_token")
      .dataset("dataset")
      .host("host")
      .build();

    DatadogTagForContainerLogging datadogTagForContainerLogging = DatadogTagForContainerLogging.builder()
      .name("name")
      .value("value")
      .build();

    List<DatadogTagForContainerLogging> tagsList = Arrays.asList(datadogTagForContainerLogging);

    DatadogLoggingConfiguration datadogLoggingConfiguration = DatadogLoggingConfiguration.builder()
      .apiKey("api_key")
      .host("host")
      .tags(tagsList)
      .build();

    ContainerLoggingHttpHeader containerLoggingHttpHeader = ContainerLoggingHttpHeader.builder()
      .name("name")
      .value("value")
      .build();

    List<ContainerLoggingHttpHeader> headersList = Arrays.asList(containerLoggingHttpHeader);

    ContainerLoggingConfigurationHttp1 containerLoggingConfigurationHttp1 = ContainerLoggingConfigurationHttp1.builder()
      .compression(ContainerLoggingHttpCompression.NONE)
      .format(ContainerLoggingHttpFormat.JSON)
      .headers(headersList)
      .host("host")
      .password("password")
      .path("path")
      .port(55354L)
      .user("user")
      .build();

    NewRelicLoggingConfiguration newRelicLoggingConfiguration = NewRelicLoggingConfiguration.builder()
      .host("host")
      .ingestionKey("ingestion_key")
      .build();

    ContainerLoggingSplunkConfiguration containerLoggingSplunkConfiguration =
      ContainerLoggingSplunkConfiguration.builder().host("host").token("token").build();

    TcpLoggingConfiguration tcpLoggingConfiguration = TcpLoggingConfiguration.builder()
      .host("host")
      .port(44671L)
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
      ContainerRegistryAuthenticationBasic.builder().password("password").username("username").build();

    ContainerRegistryAuthenticationDockerHub containerRegistryAuthenticationDockerHub =
      ContainerRegistryAuthenticationDockerHub.builder()
        .personalAccessToken("personal_access_token")
        .username("username")
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
      .cpu(191L)
      .gpuClasses(gpuClassesList)
      .memory(909130690L)
      .shmSize(64L)
      .storageAmount(699558298076245L)
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

    List<String> commandList1 = Arrays.asList("command");

    ContainerGroupProbeExec containerGroupProbeExec = ContainerGroupProbeExec.builder().command(commandList1).build();

    ContainerGroupGRpcProbe containerGroupGRpcProbe = ContainerGroupGRpcProbe.builder()
      .port(37648L)
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
        .port(29069L)
        .scheme(HttpScheme.HTTP)
        .build();

    ContainerGroupTcpProbe containerGroupTcpProbe = ContainerGroupTcpProbe.builder().port(13817L).build();

    ContainerGroupLivenessProbe containerGroupLivenessProbe = ContainerGroupLivenessProbe.builder()
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

    UpdateContainerGroupNetworking updateContainerGroupNetworking = UpdateContainerGroupNetworking.builder()
      .port(17025L)
      .build();

    QueueBasedAutoscalerConfiguration queueBasedAutoscalerConfiguration = QueueBasedAutoscalerConfiguration.builder()
      .desiredQueueLength(53L)
      .maxDownscalePerMinute(59L)
      .maxReplicas(321L)
      .maxUpscalePerMinute(100L)
      .minReplicas(54L)
      .pollingPeriod(140L)
      .build();

    ContainerGroupReadinessProbe containerGroupReadinessProbe = ContainerGroupReadinessProbe.builder()
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

    ContainerGroupScalingAction containerGroupScalingAction = ContainerGroupScalingAction.builder()
      .replicas(461L)
      .schedule("7kwC/T8C   da       x6Ci   bM-rgGYn     bDY6,vT")
      .build();

    List<ContainerGroupScalingAction> scalingActionsList = Arrays.asList(containerGroupScalingAction);

    ContainerGroupStartupProbe containerGroupStartupProbe = ContainerGroupStartupProbe.builder()
      .exec(containerGroupProbeExec)
      .failureThreshold(15L)
      .grpc(containerGroupGRpcProbe)
      .http(containerGroupHttpProbeConfiguration)
      .initialDelaySeconds(503L)
      .periodSeconds(3L)
      .successThreshold(2L)
      .tcp(containerGroupTcpProbe)
      .timeoutSeconds(10L)
      .build();

    ContainerGroupPatch containerGroupPatch = ContainerGroupPatch.builder()
      .container(updateContainer)
      .countryCodes(countryCodesList)
      .displayName("ykW8yoj HBQ")
      .livenessProbe(containerGroupLivenessProbe)
      .networking(updateContainerGroupNetworking)
      .queueAutoscaler(queueBasedAutoscalerConfiguration)
      .readinessProbe(containerGroupReadinessProbe)
      .replicas(102L)
      .scalingActions(scalingActionsList)
      .scheduledScalingEnabled(true)
      .startupProbe(containerGroupStartupProbe)
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
